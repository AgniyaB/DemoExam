package org.company.app.ui;

import org.company.app.Application;
import org.company.app.database.entity.GenderEnum;
import org.company.app.database.entity.UserEntity;
import org.company.app.database.manager.UserEntityManager;
import org.company.app.util.BaseForm;
import org.company.app.util.CustomTableModel;
import org.company.app.util.DialogUtil;

import javax.jws.soap.SOAPBinding.Use;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomTableForm extends BaseForm
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

    private CustomTableModel<UserEntity> model;

    private boolean ageSort = false;
    private boolean idSort = true;

    private int maxRows;
    private int actualRows;

    private JPanel mainPanel;
    private JTable table;
    private JButton addButton;
    private JButton idSortButton;
    private JButton ageSortButton;
    private JComboBox genderSortBox;
    private JButton clearSortButton;
    private JButton helpButton;
    private JButton dealWithAuthorButton;
    private JLabel rowCountLabel;

    public CustomTableForm()
    {
        setContentPane(mainPanel);

        initTable();
        initButtons();
        initBoxes();

        setVisible(true);
    }

    private void initTable()
    {
        table.getTableHeader().setReorderingAllowed(false);

        try {
            model = new CustomTableModel<>(
                    UserEntity.class,
                    new String[]{
                            "ID", "Логин", "Пароль", "Гендер", "Возраст", "Работа"
                    },
                    userEntityManager.getAll()
            );
            table.setModel(model);
            actualRows = maxRows = model.getValues().size();
            setRowCountInfo();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                if(e.getClickCount() == 2 && row != -1) {
                    new EditUserForm(CustomTableForm.this, model.getValues().get(row), row);
                }
            }
        });

        table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int row = table.getSelectedRow();
                if(e.getKeyCode() == KeyEvent.VK_DELETE && row != -1)
                {
                    if(DialogUtil.showConfirm(CustomTableForm.this, "Вы уверены, что хотите удалить данную запись?")) {
                        try {
                            userEntityManager.deleteById(model.getValues().get(row).getId());
                            model.getValues().remove(row);
                            model.fireTableDataChanged();

                            actualRows--;
                            maxRows--;
                            setRowCountInfo();

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
            }
        });

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                final Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if(model.getValues().get(row).getAge() >= 100) {
                    component.setBackground(new Color(240, 128, 128));
                } else {
                    component.setBackground(Color.WHITE);
                }

                return component;
            }
        });
    }

    private void initButtons()
    {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUserForm(CustomTableForm.this);
            }
        });

        /*
        варианты регистрации слушателя сверху и снизу работают одинаково
         */

        idSortButton.addActionListener(e -> {
            Collections.sort(model.getValues(), new Comparator<UserEntity>() {
                @Override
                public int compare(UserEntity o1, UserEntity o2) {
                    if(idSort) {
                        return Integer.compare(o2.getId(), o1.getId());
                    } else {
                        return Integer.compare(o1.getId(), o2.getId());
                    }
                }
            });
            idSort = !idSort;
            model.fireTableDataChanged();
        });

        ageSortButton.addActionListener(e -> {
            Collections.sort(model.getValues(), new Comparator<UserEntity>() {
                @Override
                public int compare(UserEntity o1, UserEntity o2) {
                    if(ageSort) {
                        return Integer.compare(o1.getAge(), o2.getAge());
                    } else {
                        return Integer.compare(o2.getAge(), o1.getAge());
                    }
                }
            });
            ageSort = !ageSort;
            model.fireTableDataChanged();
        });

        clearSortButton.addActionListener(e -> {
            genderSortBox.setSelectedIndex(0);
        });

        helpButton.addActionListener(e -> {
            DialogUtil.showInfo(this, "Редактирование по двойному клику, удаление по кнопке DELETE");
        });

        dealWithAuthorButton.addActionListener(e -> {
            DialogUtil.showInfo(this, "Связаться с разработчиком можно по email \"student115@itmo.ru\"");
        });
    }

    private void initBoxes()
    {
        genderSortBox.addItem("Все гендеры");
        genderSortBox.addItem("Мужской");
        genderSortBox.addItem("Женский");

        genderSortBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        List<UserEntity> allUsers = userEntityManager.getAll();
                        maxRows = allUsers.size();
                        int index = genderSortBox.getSelectedIndex();


                        if(index == 1) {
                            allUsers.removeIf(userEntity -> userEntity.getGender() == GenderEnum.FEMALE);
                        } else if(index == 2) {
                            allUsers.removeIf(userEntity -> userEntity.getGender() == GenderEnum.MALE);
                        }

                        ageSort = false;
                        idSort = true;
                        model.setValues(allUsers);
                        model.fireTableDataChanged();

                        actualRows = allUsers.size();
                        setRowCountInfo();

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });
    }

    public void setRowCountInfo()
    {
        rowCountLabel.setText("( " + actualRows + " / " + maxRows + " )");
    }

    @Override
    public int getFormWidth() {
        return 800;
    }

    @Override
    public int getFormHeight() {
        return 500;
    }

    public CustomTableModel<UserEntity> getModel() {
        return model;
    }

    public int getMaxRows() {
        return maxRows;
    }

    public CustomTableForm setMaxRows(int maxRows) {
        this.maxRows = maxRows;
        return this;
    }

    public int getActualRows() {
        return actualRows;
    }

    public CustomTableForm setActualRows(int actualRows) {
        this.actualRows = actualRows;
        return this;
    }
}
