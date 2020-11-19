package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public AddUserForm(TestForm mainForm)
    {
        this.mainForm = mainForm;
        setContentPane(mainPanel);

        initButtons();

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
        return 225;
    }
}
