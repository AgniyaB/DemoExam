package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;

public class AddUserForm extends BaseForm
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());
    private final TestForm mainForm;

    private JPanel mainPanel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JTextField ageField;
    private JTextField jobField;
    private JButton backButton;
    private JButton saveButton;
    private JComboBox genderBox;

    public AddUserForm(TestForm mainForm)
    {
        this.mainForm = mainForm;
        setContentPane(mainPanel);

        initBoxes();
        initButtons();

        setVisible(true);
    }

    private void initBoxes()
    {
        genderBox.addItem("Выберите гендер");
        genderBox.addItem("Мужчина");
        genderBox.addItem("Женщина");
        genderBox.addItem("Вертолет");

        //получить
        //genderBox.getSelectedItem();
        //genderBox.getSelectedIndex();

        //слушатель
        genderBox.addItemListener(e -> {
            System.out.println(e.getStateChange() + " " + e.getItem());
        });
        //2 - старый объект
        //1 - новый
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> {
            back();
        });

        saveButton.addActionListener(e -> {
            UserEntity userEntity = new UserEntity(
                    loginField.getText(),
                    new String(passwordField.getPassword()),
                    Integer.parseInt(ageField.getText()),
                    jobField.getText()
            );

            try {
                userEntityManager.add(userEntity);
                mainForm.update();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            back();
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
        return 300;
    }
}
