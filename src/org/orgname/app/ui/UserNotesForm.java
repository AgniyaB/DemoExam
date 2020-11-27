package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserNotesForm extends BaseForm
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());
    private final MainForm mainForm;
    private final UserEntity userEntity;

    private JPanel mainPanel;
    private JTextArea textArea;
    private JButton saveButton;
    private JButton backButton;

    public UserNotesForm(MainForm mainForm)
    {
        this.mainForm = mainForm;
        this.userEntity = mainForm.getUserEntity();
        setContentPane(mainPanel);

        initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userEntity.setNotes(textArea.getText());

                try {
                    userEntityManager.update(userEntity);
                    mainForm.loadUserData();
                    back();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    private void back()
    {
        dispose();
        mainForm.setVisible(true);
    }

    @Override
    public int getFormWidth() {
        return 400;
    }

    @Override
    public int getFormHeight() {
        return 400;
    }
}
