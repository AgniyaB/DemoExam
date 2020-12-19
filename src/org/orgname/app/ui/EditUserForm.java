package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.GenderEnum;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseSubForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JComboBox genderBox;
    private JTextField ageField;
    private JTextField jobField;
    private JButton backButton;
    private JButton saveButton;

    public EditUserForm(CustomTableForm mainForm, UserEntity userEntity, int rowIndex)
    {
        super(mainForm);
        this.userEntity = userEntity;
        this.rowIndex = rowIndex;
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
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeSubForm();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //подразумеваются проверки полей на корректность
                userEntity.setLogin(loginField.getText());
                userEntity.setPassword(new String(passwordField.getPassword()));
                userEntity.setGender((GenderEnum) genderBox.getSelectedItem());
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
