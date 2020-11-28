package org.company.app.ui;

import org.company.app.data.entity.UserEntity;
import org.company.app.util.BaseForm;

import javax.swing.*;

public class MainForm extends BaseForm
{
    private final UserEntity userEntity;

    private JPanel mainPanel;
    private JTextArea textAre;
    private JButton exitButton;

    public MainForm(UserEntity userEntity)
    {
        this.userEntity = userEntity;
        setContentPane(mainPanel);

        initButtons();
        loadUserData();

        setVisible(true);
    }

    private void initButtons()
    {
        exitButton.addActionListener(e -> {
            dispose();
            new StartForm();
        });
    }

    public void loadUserData()
    {
        StringBuilder sb = new StringBuilder("  Авторизованный пользователь:\n");
        sb.append("   ID ").append(userEntity.getId()).append("\n");
        sb.append("   Логин ").append(userEntity.getLogin()).append("\n");
        sb.append("   Пароль ").append(userEntity.getPassword()).append("\n");
        sb.append("   Гендер ").append(userEntity.getGender()).append("\n");
        sb.append("   Возраст ").append(userEntity.getAge()).append("\n");
        sb.append("   Работа ").append(userEntity.getJob()).append("\n");

        textAre.setText(sb.toString());
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
