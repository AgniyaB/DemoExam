package org.company.app.ui;

import org.company.app.Application;
import org.company.app.database.entity.UserEntity;
import org.company.app.database.manager.UserEntityManager;
import org.company.app.util.BaseForm;

import javax.swing.*;
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

        initElements();
        initButtons();

        setVisible(true);
    }

    private void initElements()
    {
        textArea.setEditable(false);
    }

    private void initButtons()
    {
        //все 3 варианта эквивалентны друг другу
        /*loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(1);
            }
        });

        loadButton.addActionListener(e -> System.out.println(2));

        loadButton.addActionListener(e -> {
            System.out.println(3);
        });*/

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    update();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        addButton.addActionListener(e -> {
            //dispose(); //полностью закрывает форму
            setVisible(false);
            new AddUserForm(this);
        });
    }

    public void update() throws SQLException
    {
        List<UserEntity> users = userEntityManager.getAll();
        StringBuilder sb = new StringBuilder("Список всех пользователей: \n");
        for(UserEntity u : users) {
            sb.append("    ").append(u).append("\n");
        }
        textArea.setText(sb.toString());
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
