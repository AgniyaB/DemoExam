package org.company.app.ui;

import org.company.app.util.BaseForm;

import javax.swing.*;

public class StartForm extends BaseForm
{
    private JPanel mainPanel;
    private JButton authButton;
    private JButton registerButton;

    public StartForm()
    {
        setContentPane(mainPanel);

        initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        authButton.addActionListener(e -> {
            dispose();
            new AuthForm();
        });

        registerButton.addActionListener(e -> {
            dispose();
            new RegistrationForm();
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
