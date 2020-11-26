package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.GenderEnum;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseSubForm;
import org.orgname.app.util.DialogUtil;

import javax.swing.*;
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
    private JButton backButton;
    private JButton saveButton;

    public EditUserForm(MainForm mainForm)
    {
        super(mainForm);
        this.userEntity = mainForm.getUserEntity();
        setContentPane(mainPanel);

        initFields();
        initButtons();

        mainForm.setEnabled(false);
        setVisible(true);
    }

    private void initFields()
    {
        idField.setEnabled(false);
        idField.setText(String.valueOf(userEntity.getId()));

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
        backButton.addActionListener(e -> closeSubForm());

        saveButton.addActionListener(e -> {
            userEntity.setLogin(loginField.getText());
            userEntity.setPassword(new String(passwordField.getPassword()));
            userEntity.setGender((GenderEnum) genderBox.getSelectedItem());
            userEntity.setAge(Integer.parseInt(ageField.getText()));
            userEntity.setJob(jobField.getText());

            try {
                userEntityManager.update(userEntity);
                mainForm.initUserData();
                closeSubForm();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
                DialogUtil.showError(this, "Не удалось сохранить данные");
            }
        });

    }

    @Override
    public int getFormWidth() {
        return 600;
    }

    @Override
    public int getFormHeight() {
        return 300;
    }
}
