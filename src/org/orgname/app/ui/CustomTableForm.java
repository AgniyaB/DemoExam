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
    private JButton addButton;

    public CustomTableForm()
    {
        setContentPane(mainPanel);

        initTable();
        initButtons();

        setVisible(true);
    }

    private void initTable()
    {
        table.getTableHeader().setReorderingAllowed(false);

        try {
            model = new CustomTableModel<>(
                    UserEntity.class,
                    new String[]{
                            "ID", "Логин", "Пароль", "Гендер", "Возраст", "Работа", "Заметки"
                    },
                    userEntityManager.getAll()
            );
            table.setModel(model);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int rowIndex = table.getSelectedRow();
                if(e.getKeyCode() == KeyEvent.VK_DELETE && rowIndex != -1)
                {
                    if(DialogUtil.showConfirm(CustomTableForm.this, "Вы точно хотите удалить данную запись?")) {
                        try {
                            userEntityManager.deleteById(model.getValues().get(rowIndex).getId());
                            model.getValues().remove(rowIndex);
                            model.fireTableDataChanged();

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
                    new EditUserForm(CustomTableForm.this, model.getValues().get(row), row);
                }
            }
        });
    }

    private void initButtons()
    {
        addButton.addActionListener(e -> {
            new AddUserForm(CustomTableForm.this);
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

    public CustomTableModel<UserEntity> getModel() {
        return model;
    }
}
