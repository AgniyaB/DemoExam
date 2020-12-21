package org.orgname.app.ui;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.orgname.app.Application;
import org.orgname.app.database.entity.ClientEntity;
import org.orgname.app.database.manager.ClientEntityManager;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.CustomTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ClientTableForm extends BaseForm
{
    private final ClientEntityManager clientEntityManager = new ClientEntityManager(Application.getInstance().getDatabase());
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-hh.mm.ss");
    private final Gson gson;

    private CustomTableModel<ClientEntity> model;

    private JPanel mainPanel;
    private JTable table;
    private JButton addButton;
    private JButton backupButton;

    public ClientTableForm()
    {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.serializeNulls();
        gson = builder.create();

        setContentPane(mainPanel);

        initTable();
        initButtons();

        setVisible(true);
    }

    private void initTable()
    {
        table.getTableHeader().setReorderingAllowed(false);

        table.setRowHeight(128);

        try {
            model = new CustomTableModel<>(
                    ClientEntity.class,
                    clientEntityManager.getAll(),
                    new String[]{
                            "ID", "Имя", "Фамилия", "Отчество", "День рождения", "Дата регистрации", "eMail", "Телефон", "Гендер", "Путь до картинки"
                    }
            );
            table.setModel(model);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void initButtons()
    {
        /*//эти 2 варианта работают одинаково, просто разная реализация

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        addButton.addActionListener(e -> {

        });*/

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
