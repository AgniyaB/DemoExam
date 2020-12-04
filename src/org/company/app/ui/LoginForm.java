package org.company.app.ui;

import org.company.app.Application;
import org.company.app.database.entity.UserEntity;
import org.company.app.database.manager.UserEntityManager;
import org.company.app.util.BaseForm;
import org.company.app.util.DialogUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginForm extends BaseForm
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

    private JPanel mainPanel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton backButton;

    public LoginForm()
    {
        setContentPane(mainPanel);

        initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String password = new String(passwordField.getPassword());

                if(login.isEmpty() || password.isEmpty()) {
                    DialogUtil.showError("Введите логин и пароль");
                    return;
                }

                try {
                    UserEntity userEntity = userEntityManager.getByLoginAndPassword(login, password);
                    if(userEntity != null) {
                        dispose();
                        new MainForm(userEntity);
                    } else {
                        DialogUtil.showError("Неверный логин/пароль");
                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    DialogUtil.showError("Ошибка подключения к бд");
                }

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StartForm();
            }
        });
    }

    @Override
    public int getFormWidth() {
        return 400;
    }

    @Override
    public int getFormHeight() {
        return 400;
    }
}
