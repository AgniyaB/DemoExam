package org.company.app.ui;

import org.company.app.Application;
import org.company.app.data.entity.ClientEntity;
import org.company.app.data.manager.ClientEntityManager;
import org.company.app.util.BaseForm;
import org.company.app.util.CustomTableModel;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class ClientTableForm extends BaseForm
{
    private final ClientEntityManager clientEntityManager = Application.getInstance().getClientEntityManager();

    private CustomTableModel<ClientEntity> model;

    private boolean blockFilter = false;

    private boolean idSort = true;
    private boolean birthdaySort = false;

    private JPanel mainPanel;
    private JTable table;
    private JButton idSortButton;
    private JButton birthdaySortButtton;
    private JComboBox genderSortBox;
    private JButton clearSortButton;
    private JComboBox testSecondSortBox;
    private JLabel rowCountLabel;
    private JButton addClientButton;

    public ClientTableForm()
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

        table.setRowHeight(128);

        try {
            model = new CustomTableModel<>(
                    ClientEntity.class,
                    new String[]{
                            "ID", "Имя", "Фамилия", "Отчество", "Дата рождения", "Дата регистрации", "Email", "Телефон", "Гендер", "Аватарка"
                    },
                    clientEntityManager.getAll()
            );
            table.setModel(model);
            updateRowCountLabel(model.getValues().size());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if(Application.isAdminMode()) {
            table.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int row = table.getSelectedRow();
                    if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                        //...
                    }
                }
            });
        }
    }

    private void initButtons()
    {
        idSortButton.addActionListener(e -> {
            model.sort(new Comparator<ClientEntity>() {
                @Override
                public int compare(ClientEntity o1, ClientEntity o2) {
                    if(idSort) {
                        return Integer.compare(o2.getId(), o1.getId());
                    } else {
                        return Integer.compare(o1.getId(), o2.getId());
                    }
                }
            });
            idSort = !idSort;
            birthdaySort = false;
        });

        birthdaySortButtton.addActionListener(e -> {
            model.sort((o1, o2) -> {
                if(birthdaySort) {
                    return o2.getBirthday().compareTo(o1.getBirthday());
                } else {
                    return o1.getBirthday().compareTo(o2.getBirthday());
                }
            });
            birthdaySort = !birthdaySort;
            idSort = false;
        });

        clearSortButton.addActionListener(e -> {
            blockFilter = true;
            genderSortBox.setSelectedIndex(0);
            blockFilter = false;
            testSecondSortBox.setSelectedIndex(0);
        });

        if(!Application.isAdminMode()) {
            addClientButton.setVisible(false);
        }
    }

    private void initBoxes()
    {
        genderSortBox.addItem("Все");
        genderSortBox.addItem("Мужской");
        genderSortBox.addItem("Женский");

        genderSortBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    if(!blockFilter) {
                        filterBoxes();
                    }
                }
            }
        });

        testSecondSortBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    if(!blockFilter) {
                        filterBoxes();
                    }
                }
            }
        });

        testSecondSortBox.addItem("Все");
        testSecondSortBox.addItem("Начинаются на А");
    }

    private void filterBoxes()
    {
        try {
            List<ClientEntity> allClients = clientEntityManager.getAll();
            int max = allClients.size();

            if(genderSortBox.getSelectedIndex() == 1) {
                allClients.removeIf(clientEntity -> clientEntity.getGenderCode() == 'ж');
            } else if(genderSortBox.getSelectedIndex() == 2) {
                allClients.removeIf(clientEntity -> clientEntity.getGenderCode() == 'м');
            }

            if(testSecondSortBox.getSelectedIndex() == 1) {
                allClients.removeIf(clientEntity -> clientEntity.getFirstname().charAt(0) != 'А');
            }

            model.setValues(allClients);
            model.fireTableDataChanged();
            updateRowCountLabel(max);

            idSort = true;
            birthdaySort = false;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void updateRowCountLabel()
    {
        try {
            updateRowCountLabel(clientEntityManager.getAll().size());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void updateRowCountLabel(int newMax)
    {
        rowCountLabel.setText("( " + model.getValues().size() + " / " + newMax + " )");
    }

    @Override
    public int getFormWidth() {
        return 1000;
    }

    @Override
    public int getFormHeight() {
        return 600;
    }
}
