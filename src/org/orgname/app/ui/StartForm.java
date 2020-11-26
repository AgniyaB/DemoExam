package org.orgname.app.ui;

import org.orgname.app.util.BaseForm;

import javax.swing.*;

public class StartForm extends BaseForm
{
    private JPanel mainPanel;
    private JButton loginButton;
    private JButton registerButton;

    public StartForm()
    {
        setContentPane(mainPanel);

        initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        loginButton.addActionListener(e -> {
            dispose();
            new LoginForm();
        });

        registerButton.addActionListener(e -> {
            dispose();
            new RegisterForm();
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
