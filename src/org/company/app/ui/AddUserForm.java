package org.company.app.ui;

import org.company.app.Application;
import org.company.app.data.GenderEnum;
import org.company.app.data.entity.UserEntity;
import org.company.app.data.manager.UserEntityManager;
import org.company.app.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;

public class AddUserForm extends BaseForm
{
    private final UserEntityManager userEntityManager = Application.getInstance().getUserEntityManager();
    private final TestForm mainForm;

    private JPanel mainPanel;
    private JTextField loginField;
    private JTextField jobField;
    private JPasswordField passwordField;
    private JButton backButton;
    private JButton addButton;
    private JTextField ageField;
    private JComboBox genderBox;

    public AddUserForm(TestForm mainForm)
    {
        this.mainForm = mainForm;
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
        backButton.addActionListener(e -> back());

        addButton.addActionListener(e -> {
            //тут должны быть проверки полей на корректноть, но мне лень
            UserEntity user = new UserEntity(
                    loginField.getText(),
                    new String(passwordField.getPassword()),
                    Integer.parseInt(ageField.getText()),
                    jobField.getText()
            );

            //GenderEnum genderEnum = (GenderEnum) genderBox.getSelectedItem();

            try {
                userEntityManager.add(user);
                mainForm.update();
                back();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    private void back()
    {
        dispose();
        mainForm.setVisible(true);
    }

    @Override
    public int getFormWidth() {
        return 500;
    }

    @Override
    public int getFormHeight() {
        return 250;
    }
}
