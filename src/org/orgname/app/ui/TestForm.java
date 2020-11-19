package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class TestForm extends BaseForm
{
    private final TestForm localInstance;
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

    private JPanel mainPanel;
    private JTextArea textArea1;
    private JButton загрузитьДанныеButton;
    private JButton addButton;

    public TestForm()
    {
        localInstance = this;
        setContentPane(mainPanel);

        textArea1.setEditable(false);
        initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        загрузитьДанныеButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });

        /*addButton.addActionListener(e -> {
            setVisible(false);
            new AddUserForm(this);
        });*/

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new AddUserForm(localInstance);
            }
        });
    }

    public void update()
    {
        try {
            List<UserEntity> users = userEntityManager.getAll();
            StringBuilder sb = new StringBuilder();
            users.forEach(u -> {
                sb.append(u).append("\n");
            });
            textArea1.setText(sb.toString());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
