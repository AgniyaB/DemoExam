package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class UsersTableForm extends BaseForm
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

    private JPanel mainPanel;
    private JTable table;

    public UsersTableForm()
    {
        setContentPane(mainPanel);

        initTable();

        setVisible(true);
    }

    private void initTable()
    {
        table.getTableHeader().setReorderingAllowed(false);

        DefaultTableModel model = new DefaultTableModel() {
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
        model.addColumn("Заметки");

        try {
            List<UserEntity> users = userEntityManager.getAll();
            for(UserEntity user : users) {
                model.addRow(new Object[] {
                        user.getId(),
                        user.getLogin(),
                        user.getPassword(),
                        user.getGender(),
                        user.getAge(),
                        user.getJob(),
                        user.getNotes()
                });
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public int getFormWidth() {
        return 800;
    }

    @Override
    public int getFormHeight() {
        return 400;
    }
}
