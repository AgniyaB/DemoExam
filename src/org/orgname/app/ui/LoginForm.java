package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class LoginForm extends BaseForm
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

    private JPanel mainPanel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton backButton;
    private JButton loginButton;

    public LoginForm()
    {
        setContentPane(mainPanel);

        initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> {
            dispose();
            new StartForm();
        });

        loginButton.addActionListener(e -> {
            try {
                UserEntity user = userEntityManager.getByLoginAndPassword(loginField.getText(), new String(passwordField.getPassword()));
                if(user == null) {
                    DialogUtil.showError(this,"Неверный логин/пароль");
                } else {
                    dispose();
                    new MainForm(user);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @Override
    public int getFormWidth() {
        return 300;
    }

    @Override
    public int getFormHeight() {
        return 300;
    }
}
