package org.orgname.app.ui;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.orgname.app.Application;
import org.orgname.app.database.entity.ClientEntity;
import org.orgname.app.database.manager.ClientEntityManager;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.CustomTableModel;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ClientTableForm extends BaseForm
{
    private final ClientEntityManager clientEntityManager = new ClientEntityManager(Application.getInstance().getDatabase());
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-hh.mm.ss");
    private final Gson gson;

    private CustomTableModel<ClientEntity> model;

    private boolean idSort = true;
    private boolean dateSort = false;

    private JPanel mainPanel;
    private JTable table;
    private JButton addButton;
    private JButton backupButton;
    private JButton idSortButton;
    private JButton regDateSortButton;
    private JComboBox genderSortBox;
    private JComboBox firstCharSortBox;
    private JLabel rowCountLabel;

    public ClientTableForm()
    {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.serializeNulls();
        gson = builder.create();

        setContentPane(mainPanel);

        initTable();
        initBoxes();
        initButtons();

        setVisible(true);
    }

    private void initTable()
    {
        table.getTableHeader().setReorderingAllowed(false);

        //table.setRowHeight(128);

        try {
            model = new CustomTableModel<>(
                    ClientEntity.class,
                    clientEntityManager.getAll(),
                    new String[]{
                            "ID", "Имя", "Фамилия", "Отчество", "День рождения", "Дата регистрации", "eMail", "Телефон", "Гендер", "Путь до картинки"
                    }
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
                    if(e.getKeyCode() == KeyEvent.VK_DELETE) {
                        //удаление
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
            dateSort = false;
            model.fireTableDataChanged();
        });

        regDateSortButton.addActionListener(e -> {
            model.sort(new Comparator<ClientEntity>() {
                @Override
                public int compare(ClientEntity o1, ClientEntity o2) {
                    if(dateSort) {
                        return o2.getBirthday().compareTo(o1.getBirthday());
                    } else {
                        return o1.getBirthday().compareTo(o2.getBirthday());
                    }
                }
            });
            dateSort = !dateSort;
            idSort = false;
            model.fireTableDataChanged();
        });

        if(Application.isAdminMode()) {
            addButton.addActionListener(e -> {
                new AddClientForm(this);
            });

            backupButton.addActionListener(e -> {
                try {
                    List<ClientEntity> list = clientEntityManager.getAll();
                    Files.write(
                            Paths.get("./dump-" + dateFormat.format(new Date()) + ".json"),
                            gson.toJson(list).getBytes()
                    );

                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                }
            });
        } else {
            addButton.setVisible(false);
            backupButton.setVisible(false);
        }
    }

    private void initBoxes()
    {
        genderSortBox.addItem("Все");
        genderSortBox.addItem("Мужской");
        genderSortBox.addItem("Женкский");

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
    }

    private void updateBoxSort()
    {
        try {
            List<ClientEntity> allClients = clientEntityManager.getAll();
            int max = allClients.size();

            if(genderSortBox.getSelectedIndex() == 1) {
                allClients.removeIf(clientEntity -> clientEntity.getGenderCode() == 'ж');
            } else if(genderSortBox.getSelectedIndex() == 2) {
                allClients.removeIf(clientEntity -> clientEntity.getGenderCode() == 'м');
            }

            if(firstCharSortBox.getSelectedIndex() != 0) {
                allClients.removeIf(clientEntity ->
                        clientEntity.getFirstname().toLowerCase().charAt(0) != (char)firstCharSortBox.getSelectedItem()
                );
            }

            model.setValues(allClients);
            model.fireTableDataChanged();
            updateRowCountLabel(max);
            idSort = true;
            dateSort = false;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateRowCountLabel(int newMax)
    {
        rowCountLabel.setText("( " + model.getValues().size() + " / " + newMax + " )");
    }

    public void updateRowCountLabel()
    {
        try {
            updateRowCountLabel(clientEntityManager.getAll().size());
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
