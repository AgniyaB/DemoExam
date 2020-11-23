package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

public class AddUserForm extends BaseForm
{
    private final TestForm mainForm;
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

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

        initButtons();

        /*genderBox.addItem("Максим");
        genderBox.addItem("Мужчина");
        genderBox.addItem("Женщина");
        genderBox.addItem("Вертолет");
        */
        genderBox.addItem(Gender.MALE);
        genderBox.addItem(Gender.FEMALE);

        genderBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(e.getStateChange() + " " + e.getItem());
            }
        });

        System.out.println(genderBox.getSelectedIndex());
        System.out.println(genderBox.getSelectedItem());

        setVisible(true);
    }

    private void initButtons()
    {
        //1 и то же
        /*backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                mainForm.setVisible(true);
            }
        });*/

        backButton.addActionListener(e -> {
            dispose();
            mainForm.setVisible(true);
        });

        saveButton.addActionListener(e -> {
            try {
                addUser();
                mainForm.update();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            dispose();
            mainForm.setVisible(true);
        });
    }

    private void addUser() throws SQLException {
        userEntityManager.add(new UserEntity(
                loginField.getText(),
                new String(passwordField.getPassword()),
                Integer.parseInt(ageField.getText()),
                jobField.getText()
        ));
    }

    @Override
    public int getFormWidth() {
        return 600;
    }

    @Override
    public int getFormHeight() {
        return 250;
    }
}

enum Gender
{
    MALE("Мужчина"),
    FEMALE("Женщина");

    private final String locale;

    private Gender(String locale)
    {
        this.locale = locale;
    }

    @Override
    public String toString() {
        return this.locale;
    }
}
