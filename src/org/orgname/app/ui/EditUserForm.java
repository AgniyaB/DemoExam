package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.GenderEnum;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseSubForm;
import org.orgname.app.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class EditUserForm extends BaseSubForm<TableForm>
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());
    private final UserEntity userEntity;
    private final int rowIndex;

    private JPanel mainPanel;
    private JTextField idField;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JComboBox genderBox;
    private JTextField ageField;
    private JTextField jobField;
    private JButton backButton;
    private JButton saveButton;

    public EditUserForm(TableForm mainForm, UserEntity userEntity, int rowIndex)
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
        idField.setText(String.valueOf(userEntity.getId()));
        idField.setEditable(false);
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
        backButton.addActionListener(e -> closeSubForm());

        saveButton.addActionListener(e -> {
            //тут должны быть проверки для полей
            userEntity.setLogin(loginField.getText());
            userEntity.setPass(new String(passwordField.getPassword()));
            userEntity.setGender((GenderEnum) genderBox.getSelectedItem());
            userEntity.setAge(Integer.parseInt(ageField.getText()));
            userEntity.setJob(jobField.getText());

            try {
                userEntityManager.update(userEntity);
                mainForm.getModel().setRowEntity(rowIndex, userEntity);
                closeSubForm();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                DialogUtil.showError(this, "Не удалось обновить пользователя");
            }
        });
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
