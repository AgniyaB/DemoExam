package org.company.app.ui;

import org.company.app.Application;
import org.company.app.data.entity.UserEntity;
import org.company.app.data.manager.UserEntityManager;
import org.company.app.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;

public class AuthForm extends BaseForm
{
    private final UserEntityManager userEntityManager = Application.getInstance().getUserEntityManager();

    private JPanel mainPanel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton backButton;

    public AuthForm()
    {
        setContentPane(mainPanel);

        initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        loginButton.addActionListener(e -> {
            try {
                UserEntity user = userEntityManager.getByLoginAndPass(
                        loginField.getText(),
                        new String(passwordField.getPassword())
                );

                if(user != null) {
                    dispose();
                    new MainForm(user);
                } else {
                    System.out.println("Неверный логин / пароль");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        backButton.addActionListener(e -> {
            dispose();
            new StartForm();
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
