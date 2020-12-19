package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.GenderEnum;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.DialogUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;

public class UsersTableForm extends BaseForm
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

    private DefaultTableModel model;

    private JPanel mainPanel;
    private JTable table;
    private JButton addUserButton;

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

        table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int rowIndex = table.getSelectedRow();
                if(e.getKeyCode() == KeyEvent.VK_DELETE && rowIndex != -1)
                {
                    if(DialogUtil.showConfirm(UsersTableForm.this, "Вы точно хотите удалить данную запись?")) {
                        try {
                            userEntityManager.deleteById((int) model.getValueAt(rowIndex, 0));
                            model.removeRow(rowIndex);

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                if(e.getClickCount() == 2 && row != -1)
                {
                    Object[] rowValues = new Object[table.getColumnCount()];
                    for(int i=0; i<table.getColumnCount(); i++) {
                        rowValues[i] = table.getValueAt(row, i);
                    }

                    UserEntity userEntity = new UserEntity(
                            (int)rowValues[0],
                            (String)rowValues[1],
                            (String)rowValues[2],
                            (GenderEnum)rowValues[3],
                            (int)rowValues[4],
                            (String)rowValues[5],
                            (String)rowValues[6]
                    );

                    new EditUserForm(UsersTableForm.this, userEntity, row);
                }
            }
        });
    }

    private void initButtons()
    {
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddUserForm(UsersTableForm.this);
            }
        });
    }

    @Override
    public int getFormWidth() {
        return 800;
    }

    @Override
    public int getFormHeight() {
        return 400;
    }

    public DefaultTableModel getModel() {
        return model;
    }
}
