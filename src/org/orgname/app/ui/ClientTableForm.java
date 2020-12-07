package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.ClientEntity;
import org.orgname.app.database.manager.ClientEntityManager;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.CustomTableModel;

import javax.swing.*;
import java.sql.SQLException;

public class ClientTableForm extends BaseForm
{
    private final ClientEntityManager clientEntityManager = new ClientEntityManager(Application.getInstance().getDatabase());
    private CustomTableModel<ClientEntity> model;

    private JPanel mainPanel;
    private JTable table;

    public ClientTableForm()
    {
        setContentPane(mainPanel);

        initTable();

        setVisible(true);
    }

    private void initTable()
    {
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
