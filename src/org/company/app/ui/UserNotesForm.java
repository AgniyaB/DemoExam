package org.company.app.ui;

import org.company.app.Application;
import org.company.app.data.entity.UserEntity;
import org.company.app.data.manager.UserEntityManager;
import org.company.app.util.BaseSubForm;
import org.company.app.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class UserNotesForm extends BaseSubForm<MainForm>
{
    private final UserEntityManager userEntityManager = Application.getInstance().getUserEntityManager();
    private final UserEntity userEntity;

    private JPanel mainPanel;
    private JTextArea textArea;
    private JButton backButton;
    private JButton saveButton;

    public UserNotesForm(MainForm mainForm)
    {
        super(mainForm);
        this.userEntity = mainForm.getUserEntity();
        setContentPane(mainPanel);

        initElements();
        initButtons();

        setVisible(true);
    }

    private void initElements()
    {
        textArea.setText(userEntity.getNotes());
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> closeSubForm());

        saveButton.addActionListener(e ->
        {
            userEntity.setNotes(textArea.getText());

            try {
                userEntityManager.update(userEntity);
                mainForm.loadUserData();
                closeSubForm();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
                DialogUtil.showError("Ошибка сохранения заметок");
            }
        });
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
