package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.ClientEntity;
import org.orgname.app.database.manager.ClientEntityManager;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.CustomTableModel;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class TableForm extends BaseForm
{
    private ClientEntityManager clientEntityManager = new ClientEntityManager(Application.getInstance().getDatabase());

    private CustomTableModel<ClientEntity> model;

    private JPanel mainPanel;
    private JTable table;

    public TableForm()
    {
        setContentPane(mainPanel);

        try {
            model = new CustomTableModel<>(
                    ClientEntity.class,
                    new String[] {
                            "ID", "FirstName", "LastName", "Patronymic", "Birthday", "RegistrationDate", "Email", "Phone", "GenderCode", "PhotoPath"
                    },
                    clientEntityManager.getAll()
            );
            table.setModel(model);

            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getClickCount() == 2 && table.getSelectedRow() != -1)
                    {
                        int row = table.rowAtPoint(e.getPoint());
                        System.out.println(model.getValues().get(row));
                    }
                }
            });

            table.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    int row = table.getSelectedRow();
                    if(row != -1)
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
            });

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        setVisible(true);
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
