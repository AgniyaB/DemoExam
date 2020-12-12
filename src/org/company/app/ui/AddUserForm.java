package org.company.app.ui;

import org.company.app.Application;
import org.company.app.data.GenderEnum;
import org.company.app.data.entity.UserEntity;
import org.company.app.data.manager.UserEntityManager;
import org.company.app.util.BaseForm;
import org.company.app.util.BaseSubForm;

import javax.swing.*;
import java.sql.SQLException;

public class AddUserForm extends BaseSubForm<CustomTableForm>
{
    private final UserEntityManager userEntityManager = Application.getInstance().getUserEntityManager();

    private JPanel mainPanel;
    private JTextField loginField;
    private JTextField jobField;
    private JPasswordField passwordField;
    private JButton backButton;
    private JButton addButton;
    private JTextField ageField;
    private JComboBox genderBox;

    public AddUserForm(CustomTableForm mainForm)
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
            closeSubForm();
        });

        addButton.addActionListener(e -> {
            //тут должны быть проверки полей на корректноть, но мне лень
            UserEntity user = new UserEntity(
                    loginField.getText(),
                    new String(passwordField.getPassword()),
                    (GenderEnum) genderBox.getSelectedItem(),
                    Integer.parseInt(ageField.getText()),
                    jobField.getText(),
                    null
            );

            //GenderEnum genderEnum = (GenderEnum) genderBox.getSelectedItem();

            try {
                userEntityManager.add(user);
                mainForm.getModel().getValues().add(user);
                mainForm.getModel().fireTableDataChanged();
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
        return 250;
    }
}
