package org.company.app.ui;

import org.company.app.Application;
import org.company.app.database.entity.GenderEnum;
import org.company.app.database.entity.UserEntity;
import org.company.app.database.manager.UserEntityManager;
import org.company.app.util.BaseForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class UsersTableForm extends BaseForm
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

    DefaultTableModel model;

    private JPanel mainPanel;
    private JTable table;
    private JButton addButton;

    public UsersTableForm()
    {
        setContentPane(mainPanel);

        initTable();
        initButtons();

        setVisible(true);
    }

    private void initTable()
    {
        table.getTableHeader().setReorderingAllowed(false);

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
            for(UserEntity user : users) {
                model.addRow(new Object[]{
                        user.getId(),
                        user.getLogin(),
                        user.getPassword(),
                        user.getGender(),
                        user.getAge(),
                        user.getJob()
                });
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                if(e.getClickCount() == 2 && row != -1) {
                    Object[] rowValues = new Object[table.getColumnCount()];
                    for(int i=0; i<table.getColumnCount(); i++) {
                        rowValues[i] = table.getValueAt(row, i);
                    }
                    //System.out.println(Arrays.toString(rowValues));
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
    }

    private void initButtons()
    {
        addButton.addActionListener(e -> {
            new CreateUserForm(this);
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

    public DefaultTableModel getModel() {
        return model;
    }
}
