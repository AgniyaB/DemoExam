package org.company.app.ui;

import org.company.app.Application;
import org.company.app.database.entity.GenderEnum;
import org.company.app.database.entity.UserEntity;
import org.company.app.database.manager.UserEntityManager;
import org.company.app.util.BaseSubForm;

import javax.swing.*;
import java.sql.SQLException;

public class EditUserForm extends BaseSubForm<CustomTableForm>
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

    private UserEntity userEntity;
    private int rowIndex;

    private JPanel mainPanel;
    private JTextField idField;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JTextField ageField;
    private JTextField jobField;
    private JComboBox genderBox;
    private JButton cancelButton;
    private JButton saveButton;

    public EditUserForm(CustomTableForm mainForm, UserEntity userEntity, int rowIndex)
    {
        super(mainForm);
        this.userEntity = userEntity;
        this.rowIndex = rowIndex;

        setContentPane(mainPanel);

        initFields();
        initButtons();

        setVisible(true);
    }

    private void initFields()
    {
        idField.setEditable(false);
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
        cancelButton.addActionListener(e -> closeSubForm());

        saveButton.addActionListener(e -> {
            //тут должны быть проверки на корректность полей
            userEntity.setLogin(loginField.getText());
            userEntity.setPassword(new String(passwordField.getPassword()));
            userEntity.setGender((GenderEnum)genderBox.getSelectedItem());
            userEntity.setAge(Integer.parseInt(ageField.getText()));
            userEntity.setJob(jobField.getText());

            try {
                userEntityManager.update(userEntity);
                mainForm.getModel().getValues().set(rowIndex, userEntity);
                mainForm.getModel().fireTableDataChanged();
                closeSubForm();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @Override
    public int getFormWidth() {
        return 500;
    }

    @Override
    public int getFormHeight() {
        return 500;
    }
}

