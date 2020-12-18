package org.orgname.app.ui;

import org.orgname.app.util.BaseForm;

import javax.swing.*;

public class ClientTableForm extends BaseForm
{
    private JPanel mainPanel;

    public ClientTableForm()
    {
        setContentPane(mainPanel);

        setVisible(true);
    }

    @Override
    public int getFormWidth() {
        return 600;
    }

    @Override
    public int getFormHeight() {
        return 400;
    }
}
