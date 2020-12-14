package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.ClientEntity;
import org.orgname.app.database.manager.ClientEntityManager;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.CustomTableModel;
import org.orgname.app.util.DialogUtil;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClientTableForm extends BaseForm {
    private final ClientEntityManager clientEntityManager = new ClientEntityManager(Application.getInstance().getDatabase());
    private CustomTableModel<ClientEntity> model;

    private boolean idSort;
    private boolean regDateSort;

    private JPanel mainPanel;
    private JTable table;
    private JButton regDateSortButton;
    private JButton idSortButton;
    private JComboBox genderSortBox;

    public ClientTableForm() {
        setContentPane(mainPanel);

        initTable();
        initButtons();
        initBoxes();

        setVisible(true);
    }

    private void initTable() {
        table.getTableHeader().setReorderingAllowed(false);

        try {
            model = new CustomTableModel<>(
                    ClientEntity.class,
                    new String[]{
                            "ID", "FirstName", "LastName", "Patronymic", "Birthday", "RegistrationDate", "Email", "Phone", "GenderCode", "PhotoPath"
                    },
                    clientEntityManager.getAll()
            );
            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //вешаем слушатель нажатия мышки
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    System.out.println(model.getValues().get(table.getSelectedRow()));
                }
            }
        });

        //вешаем слушатель нажатия клавиши
        table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int row = table.getSelectedRow();
                if(e.getKeyCode() == KeyEvent.VK_DELETE && row != -1) {
                    if(DialogUtil.showConfirm(ClientTableForm.this, "Вы действительно хотите удалить данную запись?")) {
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
    }

    private void initButtons()
    {
        /*
        ниже есть несколько вариантов
        можно использовать любой
        какой посчитаете более удобным для вас
        конечный результат у всех одинаковый
         */

        regDateSortButton.addActionListener(e -> {
            Collections.sort(model.getValues(), new Comparator<ClientEntity>() {
                @Override
                public int compare(ClientEntity o1, ClientEntity o2) {
                    if (!regDateSort) {
                        return o1.getRegDate().compareTo(o2.getRegDate());
                    } else {
                        return o2.getRegDate().compareTo(o1.getRegDate());
                    }
                }
            });
            regDateSort = !regDateSort;
            model.fireTableDataChanged();
        });

        idSortButton.addActionListener(e -> {
            //тоже самое только меньше кода
            //можно еще больше сократить используя лямбды
            if (!idSort) {
                Collections.sort(model.getValues(), (o1, o2) -> {
                    return Integer.compare(o1.getId(), o2.getId());
                });
            } else {
                Collections.sort(model.getValues(), (o1, o2) -> {
                    return Integer.compare(o2.getId(), o1.getId());
                });
            }
            idSort = !idSort;
            model.fireTableDataChanged();
        });

        /*idSortButton.addActionListener(e -> {
            //самый короткий вариант
            Collections.sort(model.getValues(), Comparator.comparingInt(ClientEntity::getId));
            model.fireTableDataChanged();
        });*/

        //тот же вариант только используя нашу функцию в CustomTableModel
        //model.sort((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));
    }

    private void initBoxes() {
        genderSortBox.addItem("Любой");
        genderSortBox.addItem("Мужской");
        genderSortBox.addItem("Женский");

        //вешаем слушателя на смену элемента в боксе
        genderSortBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) { //проверяем стадию ивента
                try {
                    List<ClientEntity> list = clientEntityManager.getAll(); //получаем всех клиентов
                    if (genderSortBox.getSelectedIndex() == 0) { //если новый элемент "Любой"
                        model.setValues(list);
                    } else if (genderSortBox.getSelectedIndex() == 1) { //если новый элемент "Мужской"
                        List<ClientEntity> list1 = new ArrayList<>(); //инициализируем новый список
                        for (ClientEntity c : list) { //добавляем в него все элементы из общего списка, которые подходят под критерии
                            if (c.getGenderCode() == 'м') {
                                list1.add(c);
                            }
                        }
                        model.setValues(list1);
                    } else if (genderSortBox.getSelectedIndex() == 2) { //если новый элемент "Женский"
                        List<ClientEntity> list2 = new ArrayList<>();
                        for (ClientEntity c : list) {
                            if (c.getGenderCode() == 'ж') {
                                list2.add(c);
                            }
                        }
                        model.setValues(list2);
                    }
                    model.fireTableDataChanged();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
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
