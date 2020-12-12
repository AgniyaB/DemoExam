package org.company.app.ui;

import org.company.app.Application;
import org.company.app.data.entity.UserEntity;
import org.company.app.data.manager.UserEntityManager;
import org.company.app.util.BaseForm;
import org.company.app.util.CustomTableModel;
import org.company.app.util.DialogUtil;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class CustomTableForm extends BaseForm
{
    private final UserEntityManager userEntityManager = Application.getInstance().getUserEntityManager();

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
                    new String[] {
                            "ID", "Логин", "Пароль", "Гендер", "Возраст", "Работа", "Заметки", "markBoolean"
                    },
                    userEntityManager.getAll()
            );
            table.setModel(model);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent mouseEvent)
            {
                int row = table.rowAtPoint(mouseEvent.getPoint());

                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1)
                {
                    new EditUserForm(CustomTableForm.this, model.getValues().get(row), row);
                }
            }
        });

        table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e)
            {
                int row = table.getSelectedRow();

                if(e.getKeyCode() == KeyEvent.VK_DELETE && row != -1) {

                    if(!DialogUtil.showConfirm(CustomTableForm.this, "Вы точно хотите удалить данную запись?")) {
                        return;
                    }

                    try {
                        userEntityManager.delete(model.getValues().get(row));
                        model.getValues().remove(row);
                        model.fireTableDataChanged();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });
    }

    private void initButtons()
    {
        addButton.addActionListener(e -> {
            new AddUserForm(this);
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
