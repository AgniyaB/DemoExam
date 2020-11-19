package org.orgname.app.ui;

import org.orgname.app.Main;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;

import javax.swing.*;
import java.sql.SQLException;

public class AddUserForm extends BaseForm
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Main.getInstance().getDatabase());
    private final TestForm mainForm;

    private JPanel mainPanel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JTextField ageFiled;
    private JTextField jobField;
    private JButton назадButton;
    private JButton сохранитьButton;
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
        genderBox.addItem("Выберите пол");
        genderBox.addItem("Мужской");
        genderBox.addItem("Женский");

        genderBox.addItemListener(e -> {
            //e.getStateChange()
            //2 - старое значение
            //1 - новое значение
            System.out.println(e.getStateChange() + " " + e.getItem());
        });
    }

    private void initButtons()
    {
        назадButton.addActionListener(e -> {
            dispose();
            mainForm.setVisible(true);
        });

        сохранитьButton.addActionListener(e -> {

            if(genderBox.getSelectedIndex() == 0) {
                System.out.println("Выберите пол");
                return;
            }

            try {
                addUserFromFields();
                mainForm.update();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            dispose();
            mainForm.setVisible(true);
        });
    }

    private void addUserFromFields() throws SQLException {
        System.out.println("Пол - " + genderBox.getSelectedItem());
        userEntityManager.add(new UserEntity(
                loginField.getText(),
                new String(passwordField.getPassword()),
                Integer.parseInt(ageFiled.getText()),
                jobField.getText()
        ));
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
