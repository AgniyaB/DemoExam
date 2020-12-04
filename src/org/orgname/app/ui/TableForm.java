package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.GenderEnum;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class TableForm extends BaseForm
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

    private DefaultTableModel model;

    private JPanel mainPanel;
    private JTable table;

    public TableForm()
    {
        setContentPane(mainPanel);

        initTable();
        initButtons();

        setVisible(true);
    }

    private void initTable()
    {
        table.getTableHeader().setReorderingAllowed(false);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && table.getSelectedRow() != -1)
                {
                    int row = table.rowAtPoint(e.getPoint());

                    Object[] rowValues = new Object[table.getColumnCount()];
                    for(int i=0; i<rowValues.length; i++) {
                        rowValues[i] = table.getValueAt(row, i);
                    }

                    UserEntity user = new UserEntity(
                            (int)rowValues[0],
                            (String)rowValues[1],
                            (String)rowValues[2],
                            (GenderEnum)rowValues[3],
                            (int)rowValues[4],
                            (String)rowValues[5]
                    );

                    System.out.println(user);
                }
            }
        });

        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(model);

        model.addColumn("ID");
        model.addColumn("Логин");
        model.addColumn("Пароль");
        model.addColumn("Гендер");
        model.addColumn("Возраст");
        model.addColumn("Работа");

        try {
            List<UserEntity> users = userEntityManager.getAll();
            users.forEach(u -> {
                model.addRow(new Object[] {
                        u.getId(),
                        u.getLogin(),
                        u.getPass(),
                        u.getGender(),
                        u.getAge(),
                        u.getJob()
                });
            });

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void initButtons()
    {

    }

    @Override
    public int getFormWidth() {
        return 800;
    }

    @Override
    public int getFormHeight() {
        return 600;
    }
}
