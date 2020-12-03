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
    private final int rowNumber;

    private JPanel mainPanel;
    private JTextField idField;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JComboBox genderBox;
    private JTextField ageField;
    private JTextField jobField;
    private JButton backButton;
    private JButton saveButton;

    public EditUserForm(TableForm mainForm, UserEntity userEntity, int rowNumber)
    {
        super(mainForm);
        this.mainPanel = mainPanel;
        this.userEntity = userEntity;
        this.rowNumber = rowNumber;
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
            UserEntity newUser = new UserEntity(
                    userEntity.getId(),
                    loginField.getText(),
                    new String(passwordField.getPassword()),
                    (GenderEnum) genderBox.getSelectedItem(),
                    Integer.parseInt(ageField.getText()),
                    jobField.getText()
            );

            try {
                userEntityManager.update(newUser);
                mainForm.updateRow(rowNumber, newUser);
                closeSubForm();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
                DialogUtil.showError(this, "Не удалось сохранить данные");
            }

        });
    }

    @Override
    public int getFormWidth() {
        return 450;
    }

    @Override
    public int getFormHeight() {
        return 300;
    }
}
