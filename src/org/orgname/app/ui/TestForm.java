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
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

    private JPanel mainPanel;
    private JTextArea textArea;
    private JButton loadButton;
    private JButton addButton;

    public TestForm()
    {
        setContentPane(mainPanel);

        textArea.setEditable(false);
        initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });

        //e -> это тоже самое что и сверху только короче

        addButton.addActionListener(e -> {
            setVisible(false);
            new AddUserForm(this);
        });
    }

    public void update()
    {
        try {
            List<UserEntity> users = userEntityManager.getAll();
            StringBuilder sb = new StringBuilder();
            for(UserEntity u : users) {
                sb.append(u).append("\n");
            }
            textArea.setText(sb.toString());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            textArea.setText("ОШИБКА ЗАГРУЗКИ ДАННЫХ");
        }
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
