package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.GenderEnum;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseSubForm;

import javax.swing.*;
import java.sql.SQLException;

public class AddUserForm extends BaseSubForm {
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

    private JPanel mainPanel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JTextField ageFiled;
    private JTextField jobField;
    private JButton назадButton;
    private JButton сохранитьButton;
    private JComboBox genderBox;

    public AddUserForm(TableForm mainForm) {
        super(mainForm, "Добавление нового пользователя");
        setContentPane(mainPanel);

        initBoxes();
        initButtons();

        setVisible(true);
    }

    private void initBoxes() {
        genderBox.addItem(GenderEnum.MALE);
        genderBox.addItem(GenderEnum.FEMALE);
    }

    private void initButtons() {
        назадButton.addActionListener(e -> closeSubForm());

        сохранитьButton.addActionListener(e -> {

            try {
                addUserFromFields();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            closeSubForm();
        });
    }

    private void addUserFromFields() throws SQLException {
        UserEntity user = new UserEntity(
                loginField.getText(),
                new String(passwordField.getPassword()),
                (GenderEnum)genderBox.getSelectedItem(),
                Integer.parseInt(ageFiled.getText()),
                jobField.getText()
        );
        userEntityManager.add(user);

        ((TableForm) mainForm).getTableModel().addRow(
                new Object[]{
                        user.getId(),
                        user.getLogin(),
                        user.getPassword(),
                        user.getGender(),
                        user.getAge(),
                        user.getJob()
                });
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
