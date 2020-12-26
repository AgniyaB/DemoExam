package org.company.app.ui;

import org.company.app.Application;
import org.company.app.data.entity.ClientEntity;
import org.company.app.data.manager.ClientEntityManager;
import org.company.app.util.BaseForm;
import org.company.app.util.CustomTableModel;
import org.company.app.util.DialogUtil;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ClientTableForm extends BaseForm
{
    private static final SimpleDateFormat MONTH_FORMAT = new SimpleDateFormat("MM");

    private final ClientEntityManager clientEntityManager = new ClientEntityManager(Application.getInstance().getDatabase());

    private CustomTableModel<ClientEntity> model;

    private boolean idSort = true;
    private boolean birthdaySort = false;
    private boolean regDateSort = false;

    private JPanel mainPanel;
    private JTable table;
    private JButton addClientButton;
    private JButton idSortButton;
    private JButton birthdaySortButton;
    private JComboBox genderSortBox;
    private JComboBox firstCharSortBox;
    private JButton registerSortButton;
    private JComboBox monthSortBox;

    public ClientTableForm()
    {
        setContentPane(mainPanel);

        initTable();
        initBoxes();
        initButtons();

        setVisible(true);
    }

    private void initTable()
    {
        table.getTableHeader().setReorderingAllowed(false);

        try {
            model = new CustomTableModel<>(
                ClientEntity.class,
                new String[]{
                        "ID", "Имя", "Фамилия", "Отчество", "Дата рождения", "Дата регистрации", "Email", "Телефон", "Гендер", "Путь до аватарки"
                },
                clientEntityManager.getAll()
            );
            table.setModel(model);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int row = table.getSelectedRow();
                if(e.getKeyCode() == KeyEvent.VK_DELETE && row != -1) {
                    if(DialogUtil.showConfirm(ClientTableForm.this, "Вы точно хотите удалить данную запись?"))
                    {
                        try {
                            clientEntityManager.delete(model.getValues().get(row));
                            model.getValues().remove(row);
                            model.fireTableDataChanged();

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                if(e.getClickCount() == 2 && row != -1) {
                    new EditClientForm(ClientTableForm.this, model.getValues().get(row), row);
                }
            }
        });
    }

    private void initButtons()
    {
        addClientButton.addActionListener(e -> {
            new AddClientForm(ClientTableForm.this);
        });

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
            regDateSort = false;
        });

        birthdaySortButton.addActionListener(e -> {
            model.sort(new Comparator<ClientEntity>() {
                @Override
                public int compare(ClientEntity o1, ClientEntity o2) {
                    if(birthdaySort) {
                        return o2.getBirthday().compareTo(o1.getBirthday());
                    } else {
                        return o1.getBirthday().compareTo(o2.getBirthday());
                    }
                }
            });
            birthdaySort = !birthdaySort;
            idSort = false;
            regDateSort = false;
        });

        registerSortButton.addActionListener(e -> {
            model.sort(new Comparator<ClientEntity>() {
                @Override
                public int compare(ClientEntity o1, ClientEntity o2) {
                    if(regDateSort) {
                        return o2.getRegDate().compareTo(o1.getRegDate());
                    } else {
                        return o1.getRegDate().compareTo(o2.getRegDate());
                    }
                }
            });
            regDateSort = !regDateSort;
            idSort = false;
            birthdaySort = false;
        });
    }

    private void initBoxes()
    {
        genderSortBox.addItem("Все");
        genderSortBox.addItem("Мужкой");
        genderSortBox.addItem("Женский");

        genderSortBox.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                updateBoxSort();
            }
        });

        firstCharSortBox.addItem("Все");
        for(int i=(int)'а'; i<=(int)'я'; i++) {
            firstCharSortBox.addItem((char)i);
        }

        firstCharSortBox.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                updateBoxSort();
            }
        });

        monthSortBox.addItem("Все");
        monthSortBox.addItem("Январь");
        monthSortBox.addItem("Февраль");
        monthSortBox.addItem("Март");
        monthSortBox.addItem("Апрель");
        monthSortBox.addItem("Май");
        monthSortBox.addItem("Июнь");
        monthSortBox.addItem("Июль");
        monthSortBox.addItem("Август");
        monthSortBox.addItem("Сентябрь");
        monthSortBox.addItem("Октябрь");
        monthSortBox.addItem("Ноябрь");
        monthSortBox.addItem("Декабрь");

        monthSortBox.addItemListener(e -> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                updateBoxSort();
            }
        });
    }

    private void updateBoxSort()
    {
        try {
            List<ClientEntity> allClients = clientEntityManager.getAll();

            if(genderSortBox.getSelectedIndex() == 1) {
                allClients.removeIf(clientEntity -> clientEntity.getGenderCode() == 'ж');
            } else if(genderSortBox.getSelectedIndex() == 2) {
                allClients.removeIf(clientEntity -> clientEntity.getGenderCode() == 'м');
            }

            if(firstCharSortBox.getSelectedIndex() != 0) {
                char c = (char)firstCharSortBox.getSelectedItem();
                allClients.removeIf(clientEntity -> clientEntity.getFirstname().toLowerCase().charAt(0) != c);
            }

            if(monthSortBox.getSelectedIndex() != 0) {
                allClients.removeIf(clientEntity -> monthSortBox.getSelectedIndex() != Integer.parseInt(MONTH_FORMAT.format(clientEntity.getBirthday())));
            }

            model.setValues(allClients);
            model.fireTableDataChanged();
            idSort = true;
            birthdaySort = false;
            regDateSort = false;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public int getFormWidth() {
        return 1000;
    }

    @Override
    public int getFormHeight() {
        return 600;
    }

    public CustomTableModel<ClientEntity> getModel() {
        return model;
    }
}
