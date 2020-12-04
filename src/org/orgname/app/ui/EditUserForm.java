package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.GenderEnum;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.BaseSubForm;
import sun.applet.Main;

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
    private JButton saveButton;
    private JButton backButton;

    public EditUserForm(MainForm mainForm)
    {
        super(mainForm);
        this.userEntity = mainForm.getAuthedUser();
        setContentPane(mainPanel);

        initElements();
        initButtons();

        setVisible(true);
    }

    private void initElements()
    {
        idField.setEnabled(false);
        idField.setText(String.valueOf(userEntity.getId()));

        loginField.setText(userEntity.getLogin());
        passwordField.setText(userEntity.getPass());

        genderBox.addItem(GenderEnum.MALE);
        genderBox.addItem(GenderEnum.FEMALE);
        genderBox.setSelectedItem(userEntity.getGender());

        ageField.setText(String.valueOf(userEntity.getAge()));
        jobField.setText(userEntity.getJob());
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> {
            closeSubForm();
        });

        saveButton.addActionListener(e -> {
            userEntity.setLogin(loginField.getText());
            userEntity.setPass(new String(passwordField.getPassword()));
            userEntity.setGender((GenderEnum) genderBox.getSelectedItem());
            userEntity.setAge(Integer.parseInt(ageField.getText()));
            userEntity.setJob(jobField.getText());

            try {
                userEntityManager.update(userEntity);
                mainForm.initUserData();
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
        return 400;
    }
}

