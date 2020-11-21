package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseSubForm;

import javax.swing.*;
import java.sql.SQLException;

public class AddUserForm extends BaseSubForm
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

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
        super(mainForm, "Добавление нового пользователя");
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
            closeSubForm();
        });

        сохранитьButton.addActionListener(e -> {

            if(genderBox.getSelectedIndex() == 0) {
                System.out.println("Выберите пол");
                return;
            }

            try {
                addUserFromFields();
                ((TestForm)mainForm).update();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            closeSubForm();
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
