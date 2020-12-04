package org.company.app.ui;

import org.company.app.Application;
import org.company.app.database.entity.GenderEnum;
import org.company.app.database.entity.UserEntity;
import org.company.app.database.manager.UserEntityManager;
import org.company.app.util.BaseForm;
import org.company.app.util.BaseSubForm;
import org.company.app.util.DialogUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class EditUserForm extends BaseSubForm<MainForm>
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

    private final UserEntity userEntity;

    private JPanel mainPanel;
    private JTextField idField;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JComboBox genderBox;
    private JTextField ageField;
    private JTextField jobField;
    private JButton saveButton;
    private JButton cancelButton;

    public EditUserForm(MainForm mainForm)
    {
        super(mainForm);
        this.userEntity = mainForm.getUserEntity();
        setContentPane(mainPanel);

        initFields();
        initButtons();

        setVisible(true);
    }

    private void initFields()
    {
        idField.setText(String.valueOf(userEntity.getId()));
        idField.setEditable(false);
        loginField.setText(userEntity.getLogin());
        passwordField.setText(userEntity.getPassword());
        genderBox.addItem(GenderEnum.MALE);
        genderBox.addItem(GenderEnum.FEMALE);
        genderBox.setSelectedItem(userEntity.getGender());
        ageField.setText(String.valueOf(userEntity.getAge()));
        jobField.setText(userEntity.getJob());
    }

    private void initButtons()
    {
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeSubForm();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //тут еще должны быть проверки на корректность полей
                UserEntity newUser = new UserEntity(
                        userEntity.getId(),
                        loginField.getText(),
                        new String(passwordField.getPassword()),
                        (GenderEnum)genderBox.getSelectedItem(),
                        Integer.parseInt(ageField.getText()),
                        jobField.getText()
                );

                try {
                    userEntityManager.update(newUser);
                    mainForm.setUserEntity(newUser);
                    mainForm.initUserData();
                    closeSubForm();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    DialogUtil.showError("Ошибка сохранения пользователя");
                }
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
