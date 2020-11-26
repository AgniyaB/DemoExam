package org.orgname.app.ui;

import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.util.BaseForm;

import javax.swing.*;

public class MainForm extends BaseForm
{
    private UserEntity userEntity;

    private JPanel mainPanel;
    private JTextArea textArea;
    private JButton exitButton;
    private JButton editButton;

    public MainForm(UserEntity userEntity)
    {
        this.userEntity = userEntity;
        setContentPane(mainPanel);

        initElements();
        initUserData();
        initButtons();

        setVisible(true);
    }

    private void initElements()
    {
        textArea.setEditable(false);
    }

    public void initUserData()
    {
        StringBuilder sb = new StringBuilder("Авторизованный пользователь:\n");

        sb.append("    ").append("ID ").append(userEntity.getId()).append("\n");
        sb.append("    ").append("Логин ").append(userEntity.getLogin()).append("\n");
        sb.append("    ").append("Пароль ").append(userEntity.getPassword()).append("\n");
        sb.append("    ").append("Гендер ").append(userEntity.getGender()).append("\n");
        sb.append("    ").append("Возраст ").append(userEntity.getAge()).append("\n");
        sb.append("    ").append("Работа ").append(userEntity.getJob()).append("\n");

        textArea.setText(sb.toString());
    }

    private void initButtons()
    {
        exitButton.addActionListener(e -> {
            dispose();
            new StartForm();
        });

        editButton.addActionListener(e -> new EditUserForm(this));
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

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
