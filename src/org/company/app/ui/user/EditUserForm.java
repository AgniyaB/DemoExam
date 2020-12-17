package org.company.app.ui.user;

import org.company.app.Application;
import org.company.app.data.GenderEnum;
import org.company.app.data.entity.UserEntity;
import org.company.app.data.manager.UserEntityManager;
import org.company.app.util.BaseSubForm;
import org.company.app.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class EditUserForm extends BaseSubForm<CustomTableForm>
{
    private final UserEntityManager userEntityManager = Application.getInstance().getUserEntityManager();
    private final UserEntity userEntity;
    private final int row;

    private JPanel mainPanel;
    private JTextField idField;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JComboBox genderBox;
    private JTextField ageField;
    private JTextField jobField;
    private JButton cancelButton;
    private JButton saveButton;

    public EditUserForm(CustomTableForm mainForm, UserEntity userEntity, int row)
    {
        super(mainForm);
        this.userEntity = userEntity;
        this.row = row;
        setContentPane(mainPanel);

        initFields();
        initButtons();

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
        cancelButton.addActionListener(e -> {
            closeSubForm();
        });

        saveButton.addActionListener(e -> {
            UserEntity newUser = new UserEntity(
                    userEntity.getId(),
                    loginField.getText(),
                    new String(passwordField.getPassword()),
                    (GenderEnum) genderBox.getSelectedItem(),
                    Integer.parseInt(ageField.getText()),
                    jobField.getText(),
                    userEntity.getNotes()
            );

            try {
                userEntityManager.update(newUser);
                mainForm.getModel().getValues().set(row, newUser);
                mainForm.getModel().fireTableDataChanged();
                closeSubForm();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
                DialogUtil.showError("Ошибка сохранения данных");
            }
        });
    }

    @Override
    public int getFormWidth() {
        return 400;
    }

    @Override
    public int getFormHeight() {
        return 275;
    }
}
