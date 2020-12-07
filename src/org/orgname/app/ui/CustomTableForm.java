package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.CustomTableModel;
import org.orgname.app.util.DialogUtil;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class CustomTableForm extends BaseForm
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

    private CustomTableModel<UserEntity> model;

    private JPanel mainPanel;
    private JTable table;

    public CustomTableForm()
    {
        setContentPane(mainPanel);

        initTable();

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
                    new CustomEditUserForm(CustomTableForm.this, model.getValues().get(row), row);
                }
            }
        });

        table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int row = table.getSelectedRow();
                if(e.getKeyCode() == KeyEvent.VK_DELETE && row != -1)
                {
                    if(DialogUtil.showConfirm(CustomTableForm.this, "Вы точно хотите удалить данную запись?"))
                    {
                        UserEntity userEntity = model.getValues().get(row);
                        try {
                            userEntityManager.deleteById(userEntity.getId());
                            model.getValues().remove(row);
                            model.fireTableDataChanged();

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
            }
        });

        try {
            model = new CustomTableModel<>(
                    UserEntity.class,
                    userEntityManager.getAll(),
                    new String[]{
                            "ID", "Логин", "Пароль", "Гендер", "Возраст", "Работа"
                    }
            );
            table.setModel(model);

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
        return 600;
    }

    public CustomTableModel<UserEntity> getModel() {
        return model;
    }
}
