package org.company.app.ui;

import org.company.app.Application;
import org.company.app.data.entity.UserEntity;
import org.company.app.data.manager.UserEntityManager;
import org.company.app.util.BaseForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class TestForm extends BaseForm
{
    private final UserEntityManager userEntityManager = Application.getInstance().getUserEntityManager();
    private final Random rand = new Random();

    private JPanel mainPanel;
    private JButton updateButton;
    private JTextArea text;
    private JButton addButton;
    private JButton nextButton;

    public TestForm()
    {
        setContentPane(mainPanel);

        initButtons();
    }

    private void initButtons()
    {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    userEntityManager.add(new UserEntity("Pa4ok-" + rand.nextInt(100), "1234567890", 10, "teacher"));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<UserEntity> users = userEntityManager.getAll();
                    StringBuilder sb = new StringBuilder();
                    users.forEach(u -> {
                        sb.append(u.toString()).append("\n");
                    });
                    text.setText(sb.toString());

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        nextButton.addActionListener(e -> {
            changeForm(new SecondForm());
        });
    }

    @Override
    public int getFormWidth() {
        return 600;
    }

    @Override
    public int getFormHeight() {
        return 300;
    }
}
