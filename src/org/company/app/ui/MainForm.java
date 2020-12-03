package org.company.app.ui;

import org.company.app.data.entity.UserEntity;
import org.company.app.util.BaseForm;

import javax.swing.*;

public class MainForm extends BaseForm
{
    private UserEntity userEntity;

    private JPanel mainPanel;
    private JTextArea textArea;
    private JButton exitButton;
    private JButton editButton;
    private JButton notesButton;

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

    private void initButtons()
    {
        exitButton.addActionListener(e -> {
            dispose();
            new StartForm();
        });

        editButton.addActionListener(e -> {
            new EditUserForm(this);
        });

        notesButton.addActionListener(e -> {
            new UserNotesForm(this);
        });
    }

    public void loadUserData()
    {
        StringBuilder sb = new StringBuilder("Авторизованный пользователь:\n");
        sb.append(" ID ").append(userEntity.getId()).append("\n");
        sb.append(" Логин ").append(userEntity.getLogin()).append("\n");
        sb.append(" Пароль ").append(userEntity.getPassword()).append("\n");
        sb.append(" Гендер ").append(userEntity.getGender()).append("\n");
        sb.append(" Возраст ").append(userEntity.getAge()).append("\n");
        sb.append(" Работа ").append(userEntity.getJob()).append("\n\n");
        sb.append("Заметки:\n").append(userEntity.getNotes());

        textArea.setText(sb.toString());
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
