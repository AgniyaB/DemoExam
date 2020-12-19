package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.ServiceEntity;
import org.orgname.app.database.manager.ServiceEntityManager;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.CustomTableModel;

import javax.swing.*;
import java.sql.SQLException;

public class ServiceTableForm extends BaseForm
{
    private final ServiceEntityManager serviceEntityManager = new ServiceEntityManager(Application.getInstance().getDatabase());

    private JPanel mainPanel;
    private JTable table;

    private CustomTableModel<ServiceEntity> model;

    public ServiceTableForm()
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
                    ServiceEntity.class,
                    new String[]{
                            "ID", "Название","Стоимость","Длительность","Скидка","Логотип"
                    },
                    serviceEntityManager.getAll()
            );
            table.setModel(model);

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

    public CustomTableModel<ServiceEntity> getModel() {
        return model;
    }
}
