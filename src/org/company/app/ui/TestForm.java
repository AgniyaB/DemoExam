package org.company.app.ui;

import org.company.app.Application;
import org.company.app.data.entity.UserEntity;
import org.company.app.data.manager.UserEntityManager;
import org.company.app.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class TestForm extends BaseForm
{
    private final UserEntityManager userEntityManager = Application.getInstance().getUserEntityManager();

    private JPanel mainPanel;
    private JButton updateButton;
    private JTextArea text;
    private JButton addButton;

    public TestForm()
    {
        setContentPane(mainPanel);

        text.setEditable(false);
        initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        addButton.addActionListener(e -> {
            setVisible(false);
            new AddUserForm(this);
        });

        updateButton.addActionListener(e -> {
            try {
                update();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }

    public void update() throws SQLException
    {
        List<UserEntity> users = userEntityManager.getAll();
        StringBuilder sb = new StringBuilder();
        users.forEach(u -> {
            sb.append(u.toString()).append("\n");
        });
        text.setText(sb.toString());
    }

    @Override
    public int getFormWidth() {
        return 600;
    }

    @Override
    public int getFormHeight() {
        return 300;
    }
}
