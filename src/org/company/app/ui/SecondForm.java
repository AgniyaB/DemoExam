package org.company.app.ui;

import org.company.app.util.BaseForm;

import javax.swing.*;

public class SecondForm extends BaseForm
{
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPasswordField passwordField1;
    private JButton backButton;
    private JButton отправитьButton;

    public SecondForm()
    {
        setContentPane(mainPanel);

        отправитьButton.addActionListener(e -> {
            changeForm(new ThirdForm());
        });
    }

    @Override
    public int getFormWidth() {
        return 600;
    }

    @Override
    public int getFormHeight() {
        return 200;
    }
}
