package org.company.app.ui;

import org.company.app.database.entity.UserEntity;
import org.company.app.util.BaseForm;

import javax.swing.*;

public class EditUserForm extends BaseForm
{
    private final UserEntity userEntity;

    private JPanel mainePanel;

    public EditUserForm(UserEntity userEntity)
    {
        this.userEntity = userEntity;
        setContentPane(mainePanel);


        setVisible(true);
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
