package org.company.app.ui;

import org.company.app.Application;
import org.company.app.database.entity.GenderEnum;
import org.company.app.database.entity.UserEntity;
import org.company.app.database.manager.UserEntityManager;
import org.company.app.util.BaseForm;
import org.company.app.util.BaseSubForm;
import org.company.app.util.DialogUtil;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

public class CreateUserForm extends BaseSubForm<UsersTableForm>
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

    private JPanel mainPanel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JTextField ageField;
    private JTextField jobField;
    private JButton saveButton;
    private JButton backButton;
    private JComboBox genderBox;

    public CreateUserForm(UsersTableForm mainForm)
    {
        super(mainForm);
        setContentPane(mainPanel);

        initElements();
        initButtons();

        setVisible(true);
    }

    private void initElements()
    {
        genderBox.addItem(GenderEnum.MALE);
        genderBox.addItem(GenderEnum.FEMALE);
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> {
            if(DialogUtil.showConfirm(this, "Вы точно хотите вернуться назад?")) {
                closeSubForm();
            }
        });

        saveButton.addActionListener(e ->
        {
            String login = loginField.getText();
            if(UserEntity.isLoginIncorrect(login)) {
                DialogUtil.showError(this, "Некоректный логин");
                return;
            }

            String password = new String(passwordField.getPassword());
            if(UserEntity.isPasswordIncorrect(password)) {
                DialogUtil.showError("Некоректный пароль");
                return;
            }

            String ageString = ageField.getText();
            if(UserEntity.isAgeIncorrect(ageString)) {
                DialogUtil.showError("Некоректный возраст");
                return;
            }

            String job = jobField.getText();
            if(UserEntity.isJobIncorrect(job)) {
                DialogUtil.showError("Некоректная работа");
                return;
            }

            UserEntity user = new UserEntity(
                    login,
                    password,
                    (GenderEnum)genderBox.getSelectedItem(),
                    Integer.parseInt(ageString),
                    job
            );

            try {
                userEntityManager.add(user);
                mainForm.getModel().addRow(new Object[]{
                        user.getId(),
                        user.getLogin(),
                        user.getPassword(),
                        user.getGender(),
                        user.getAge(),
                        user.getJob()
                });
                closeSubForm();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @Override
    public int getFormWidth() {
        return 400;
    }

    @Override
    public int getFormHeight() {
        return 300;
    }
}
