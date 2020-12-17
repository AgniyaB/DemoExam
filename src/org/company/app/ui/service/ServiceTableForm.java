package org.company.app.ui.service;

import org.company.app.Application;
import org.company.app.data.entity.ServiceEntity;
import org.company.app.data.manager.ServiceEntityManager;
import org.company.app.util.BaseForm;
import org.company.app.util.CustomTableModel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class ServiceTableForm extends BaseForm
{
    private final ServiceEntityManager serviceEntityManager = new ServiceEntityManager(Application.getInstance().getDatabase());

    private CustomTableModel<ServiceEntity> model;

    private JPanel mainPanel;
    private JTable table;

    public ServiceTableForm()
    {
        setContentPane(mainPanel);

        initTable();

        setVisible(true);
    }

    private void initTable()
    {
        try {
            model = new CustomTableModel<>(
                    ServiceEntity.class,
                    new String[]{
                            "ID", "Название", "Стоимость", "Длительность", "Описание", "Скидка", "Логотип"
                    },
                    serviceEntityManager.getAll()
            );
            table.setModel(model);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if(e.getClickCount() == 2 && row != -1) {
                    new EditServiceForm(ServiceTableForm.this, model.getValues().get(row), row);
                }
            }
        });
    }

    @Override
    public int getFormWidth() {
        return 800;
    }

    @Override
    public int getFormHeight() {
        return 600;
    }

    public CustomTableModel<ServiceEntity> getModel() {
        return model;
    }
}
