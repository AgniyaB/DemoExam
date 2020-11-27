package org.orgname.app.ui;

import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.util.BaseForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends BaseForm {
    private final UserEntity userEntity;

    private JTextArea textArea;
    private JPanel mainPanel;
    private JButton exitButton;
    private JButton editButton;

    public MainForm(UserEntity userEntity)
    {
        this.userEntity = userEntity;
        setContentPane(mainPanel);

        initElements();
        initButtons();
        loadUserData();

        setVisible(true);
    }

    private void initElements()
    {
        textArea.setEditable(false);
    }

    public void loadUserData()
    {
        StringBuilder sb = new StringBuilder("  Авторизованный пользователь:\n");
        sb.append("    ID ").append(userEntity.getId()).append("\n");
        sb.append("    Логин ").append(userEntity.getLogin()).append("\n");
        sb.append("    Пароль ").append(userEntity.getPassword()).append("\n");
        sb.append("    Гендер ").append(userEntity.getGender()).append("\n");
        sb.append("    Возраст ").append(userEntity.getAge()).append("\n");
        sb.append("    Работа ").append(userEntity.getJob()).append("\n");

        textArea.setText(sb.toString());
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

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new EditUserForm(MainForm.this);
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

    public UserEntity getUserEntity() {
        return userEntity;
    }
}
