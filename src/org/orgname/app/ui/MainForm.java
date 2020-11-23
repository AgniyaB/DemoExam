package org.orgname.app.ui;

import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.util.BaseForm;

import javax.swing.*;

public class MainForm extends BaseForm
{
    private final UserEntity authedUser;

    private JPanel mainPanel;
    private JTextArea textArea;
    private JButton exitButton;

    public MainForm(UserEntity authedUser)
    {
        this.authedUser = authedUser;
        setContentPane(mainPanel);

        exitButton.addActionListener(e -> {
            dispose();
            new StartForm();
        });

        StringBuilder sb = new StringBuilder();
        sb.append("  ID: ").append(authedUser.getId()).append("\n")
                .append("  Логин: ").append(authedUser.getLogin()).append("\n")
                .append("  Гендер: ").append(authedUser.getGender().toString()).append("\n")
                .append("  Возраст: ").append(authedUser.getAge()).append("\n")
                .append("  Работа: ").append(authedUser.getJob()).append("\n");

        textArea.setEditable(false);
        textArea.setText(sb.toString());

        setVisible(true);
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
