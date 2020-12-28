package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.ClientEntity;
import org.orgname.app.database.manager.ClientEntityManager;
import org.orgname.app.util.BaseSubForm;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Date;

public class AddClientForm extends BaseSubForm<ClientTableForm>
{
    private final ClientEntityManager clientEntityManager = new ClientEntityManager(Application.getInstance().getDatabase());

    private JPanel mainPanel;
    private JTextField firstnameField;
    private JTextField lastnameField;
    private JTextField patronymicField;
    private JTextField birthdayField;
    private JTextField registerField;
    private JTextField mailField;
    private JTextField phoneField;
    private JComboBox genderBox;
    private JTextField imgPathField;
    private JButton addButton;
    private JButton backButton;

    public AddClientForm(ClientTableForm mainForm)
    {
        super(mainForm);
        setContentPane(mainPanel);

        initElements();
        initButtons();

        setVisible(true);
    }

    private void initElements()
    {
        genderBox.addItem("Мужской");
        genderBox.addItem("Женский");
    }

    private void initButtons()
    {
        backButton.addActionListener(e -> closeSubForm());

        addButton.addActionListener(e -> {

            /*//должны быть проверки на корректность всех полей
            if(firstnameField.getText().isEmpty()) {
                DialogUtil.showError(this, "Введите имя");
                return;
            }*/

            ClientEntity clientEntity = new ClientEntity(
                    firstnameField.getText(),
                    lastnameField.getText(),
                    patronymicField.getText(),
                    new Date(),
                    new Date(),
                    mailField.getText(),
                    phoneField.getText(),
                    ((String)genderBox.getSelectedItem()).toLowerCase().charAt(0),
                    imgPathField.getText()
            );

            try {
                //сохряняем нового клиента в бд
                clientEntityManager.add(clientEntity);
                //добавляем его в коллекции со строками таблицы
                mainForm.getModel().getValues().add(clientEntity);
                //указываем таблице на то что данные обновились
                mainForm.getModel().fireTableDataChanged();

                mainForm.updateRowCountLabel();

                //закрываем второе окно
                closeSubForm();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @Override
    public int getFormWidth() {
        return 400;
    }

    @Override
    public int getFormHeight() {
        return 500;
    }
}
