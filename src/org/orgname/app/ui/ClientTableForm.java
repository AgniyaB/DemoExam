package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.ClientEntity;
import org.orgname.app.database.manager.ClientEntityManager;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.CustomTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ClientTableForm extends BaseForm
{
    private final ClientEntityManager clientEntityManager = new ClientEntityManager(Application.getInstance().getDatabase());

    private CustomTableModel<ClientEntity> model;

    private JPanel mainPanel;
    private JTable table;
    private JButton addButton;

    public ClientTableForm()
    {
        setContentPane(mainPanel);

        initTable();
        initButtons();

        setVisible(true);
    }

    private void initTable()
    {
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

        addButton.addActionListener(e -> {
            new AddClientForm(this);
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

    public CustomTableModel<ClientEntity> getModel() {
        return model;
    }
}
