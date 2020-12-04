package org.company.app.ui;

import org.company.app.database.entity.UserEntity;
import org.company.app.util.BaseForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends BaseForm
{
    private final UserEntity userEntity;

    private JPanel mainPanel;
    private JTextArea textArea;
    private JButton exitButton;

    public MainForm(UserEntity userEntity)
    {
        this.userEntity = userEntity;
        setContentPane(mainPanel);

        initUserData();
        initButtons();

        setVisible(true);
    }

    public void initUserData()
    {
        StringBuilder sb = new StringBuilder("Авторизованный пользователь:\n");

        sb.append("ID ").append(userEntity.getId()).append("\n");
        sb.append("Логин ").append(userEntity.getLogin()).append("\n");
        sb.append("Пароль ").append(userEntity.getPassword()).append("\n");
        sb.append("Гендер ").append(userEntity.getGender()).append("\n");
        sb.append("Возраст ").append(userEntity.getAge()).append("\n");
        sb.append("Работа ").append(userEntity.getJob()).append("\n");

        textArea.setText(sb.toString());
        textArea.setEditable(false);
    }

    private void initButtons()
    {
        exitButton.addActionListener(new ActionListener() {
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
