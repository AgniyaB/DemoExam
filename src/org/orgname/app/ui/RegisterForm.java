package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.GenderEnum;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class RegisterForm extends BaseForm
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

    private JPanel mainPanel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JTextField ageField;
    private JTextField jobField;
    private JButton backButton;
    private JButton saveButton;
    private JComboBox genderBox;

    public RegisterForm()
    {
        setContentPane(mainPanel);

        initBoxes();
        initButtons();

        setVisible(true);
    }

    private void initBoxes()
    {
        genderBox.addItem(GenderEnum.MALE);
        genderBox.addItem(GenderEnum.FEMALE);
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> {
            if(DialogUtil.showConfirm(this, "Вы точно хотите прервать регистрацию?")) {
                back();
            }
        });

        saveButton.addActionListener(e -> {
            String login = loginField.getText();
            if(UserEntity.isLoginIncorrect(login)) {
                DialogUtil.showError(this, "Логин введен некорректно");
                return;
            }

            String password = new String(passwordField.getPassword());
            if(UserEntity.isPasswordIncorrect(password)) {
                DialogUtil.showError(this, "Пароль введен некорректно");
                return;
            }

            String ageString = ageField.getText();
            if(UserEntity.isAgeIncorrect(ageString)) {
                DialogUtil.showError(this, "Возраст введен некорректно");
                return;
            }

            String job = jobField.getText();
            if(UserEntity.isJobIncorrect(job)) {
                DialogUtil.showError(this, "Работа введена некорректно");
                return;
            }

            UserEntity userEntity = new UserEntity(
                    login,
                    password,
                    (GenderEnum) genderBox.getSelectedItem(),
                    Integer.parseInt(ageString),
                    job
            );

            try {
                userEntityManager.add(userEntity);
                dispose();
                new MainForm(userEntity);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
                DialogUtil.showError(this, "Ошибка сохранения пользователя в бд");

            }
        });
    }

    private void back()
    {
        dispose();
        new StartForm();
    }

    @Override
    public int getFormWidth() {
        return 500;
    }

    @Override
    public int getFormHeight() {
        return 300;
    }
}
