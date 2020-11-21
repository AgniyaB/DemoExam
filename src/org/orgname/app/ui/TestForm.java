package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class TestForm extends BaseForm
{
    private UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());
    private final TestForm localInstance;

    private JPanel mainPanel;
    private JTextArea textArea1;
    private JButton loadButton;
    private JButton addButton;

    public TestForm()
    {
        localInstance = this;
        setContentPane(mainPanel);

        initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        loadButton.addActionListener(e -> update());

        addButton.addActionListener(e -> {
            new AddUserForm(localInstance);
        });
    }

    public void update()
    {
        try {
            List<UserEntity> users = userEntityManager.getAll();
            StringBuilder sb = new StringBuilder();
            users.forEach(u -> {
                sb.append(u).append("\n");
            });
            textArea1.setText(sb.toString());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public int getFormWidth() {
        return 600;
    }

    @Override
    public int getFormHeight() {
        return 400;
    }
}
