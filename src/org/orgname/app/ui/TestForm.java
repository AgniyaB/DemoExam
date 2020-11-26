package org.orgname.app.ui;

import org.orgname.app.Main;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class TestForm extends BaseForm
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Main.getInstance().getDatabase());

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
        //3 данных варианта делают 1 и то же
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

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dispose(); //полностью закрывает и удаляет из памяти форму
                setVisible(false);
                new AddUserForm(TestForm.this);
            }
        });
    }

    public void update() throws SQLException
    {
        List<UserEntity> users = userEntityManager.getAll();
        StringBuilder sb = new StringBuilder("Список пользователей:\n");
        for(UserEntity u : users) {
            sb.append("    ").append(u.toString()).append("\n");
        }
        textArea.setText(sb.toString());
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
