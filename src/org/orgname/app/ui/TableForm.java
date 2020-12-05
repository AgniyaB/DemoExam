package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.GenderEnum;
import org.orgname.app.database.entity.ClientEntity;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.ClientEntityManager;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.DialogUtil;
import org.orgname.app.util.ObjectTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TableForm extends BaseForm
{
    private final ClientEntityManager clientEntityManager = new ClientEntityManager(Application.getInstance().getDatabase());
    private ObjectTableModel<ClientEntity> tableModel;

    private JPanel mainPanel;
    private JTable table;
    private JButton loadButton;
    private JButton addButton;

    public TableForm()
    {
        setContentPane(mainPanel);

        initTable();
        loadTableData();
        initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        loadButton.addActionListener(e -> {
            loadTableData();
        });

        addButton.addActionListener(e -> {
            new AddUserForm(this);
        });
    }

    private void initTable()
    {
        tableModel = new ObjectTableModel<ClientEntity>() {
            @Override
            protected ClientEntity getEntityFromData(Object[] columns) {
                return new ClientEntity(
                        (int)columns[0],
                        (String)columns[1],
                        (String)columns[2],
                        (String)columns[3],
                        (Date)columns[4],
                        (Date)columns[5],
                        (String)columns[6],
                        (String)columns[7],
                        (char)columns[8],
                        (String)columns[9]
                );
            }

            @Override
            protected Object[] getDataFromEntity(ClientEntity entity) {
                return new Object[]{
                        entity.getId(),
                        entity.getFirstname(),
                        entity.getLastname(),
                        entity.getPatronymic(),
                        entity.getBirthday(),
                        entity.getRegDate(),
                        entity.getEmail(),
                        entity.getPhone(),
                        entity.getGenderCode(),
                        entity.getPhotoPath()
                };
            }
        };

        table.setModel(tableModel);
        table.getTableHeader().setReorderingAllowed(false);

        tableModel.addColumn("id");
        tableModel.addColumn("FirstName");
        tableModel.addColumn("LastName");
        tableModel.addColumn("Patronymic");
        tableModel.addColumn("Birthday");
        tableModel.addColumn("RegistrationDate");
        tableModel.addColumn("Email");
        tableModel.addColumn("Phone");
        tableModel.addColumn("GenderCode");
        tableModel.addColumn("PhotoPath");

        /*//получение записи по двойному клику
        table.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent mouseEvent)
            {
                int row = table.rowAtPoint(mouseEvent.getPoint());
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    new EditUserForm(TableForm.this, tableModel.getRowEntity(row), row);
                }
            }
        });*/

        table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int row = table.getSelectedRow();
                if(e.getKeyCode() == KeyEvent.VK_DELETE && row != -1) {
                    if(DialogUtil.showConfirm(TableForm.this, "Вы точно хотите удалить данную запись?"))
                    {
                        try {
                            clientEntityManager.delete(tableModel.getRowEntity(row));
                            tableModel.removeRow(table.getSelectedRow());

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    private void loadTableData()
    {
        try {
            List<ClientEntity> users = clientEntityManager.getAll();
            while (tableModel.getRowCount() > 0) {
                tableModel.removeRow(0);
            }
            tableModel.addRowEntities(users);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            DialogUtil.showError("Не удалось загрузить данные");
        }
    }

    /*public void updateRow(int rowNumber, UserEntity user)
    {
        tableModel.setRowEntity(rowNumber, user);
    }*/

    @Override
    public int getFormWidth() {
        return 800;
    }

    @Override
    public int getFormHeight() {
        return 400;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
