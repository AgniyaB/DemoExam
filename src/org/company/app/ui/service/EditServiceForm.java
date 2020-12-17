package org.company.app.ui.service;

import org.company.app.Application;
import org.company.app.data.entity.ServiceEntity;
import org.company.app.data.manager.ServiceEntityManager;
import org.company.app.util.BaseSubForm;
import org.company.app.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class EditServiceForm extends BaseSubForm<ServiceTableForm>
{
    private final ServiceEntityManager serviceEntityManager = new ServiceEntityManager(Application.getInstance().getDatabase());

    private ServiceEntity serviceEntity;
    private int rowNumber;

    private JPanel mainPanel;
    private JTextField idField;
    private JTextField titleField;
    private JTextField costField;
    private JTextField durationField;
    private JTextField descField;
    private JTextField discountField;
    private JTextField imgPathField;
    private JButton cancelButton;
    private JButton saveButton;

    public EditServiceForm(ServiceTableForm mainForm, ServiceEntity serviceEntity, int rowNumber)
    {
        super(mainForm);
        this.serviceEntity = serviceEntity;
        this.rowNumber = rowNumber;
        setContentPane(mainPanel);

        initFields();
        initButtons();;

        setVisible(true);
    }

    private void initFields()
    {
        idField.setEditable(false);
        idField.setText(String.valueOf(serviceEntity.getId()));
        titleField.setText(serviceEntity.getTitle());
        costField.setText(String.valueOf(serviceEntity.getCost()));
        durationField.setText(String.valueOf(serviceEntity.getDuration()));
        descField.setText(serviceEntity.getDescription());
        discountField.setText(String.valueOf(serviceEntity.getDiscount()));
        imgPathField.setText(serviceEntity.getImpPath());
    }

    private void initButtons()
    {
        cancelButton.addActionListener(e -> closeSubForm());

        saveButton.addActionListener(e -> {
            serviceEntity.setTitle(titleField.getText());
            serviceEntity.setCost(Double.parseDouble(costField.getText()));
            serviceEntity.setDuration(Integer.parseInt(durationField.getText()));
            serviceEntity.setDescription(descField.getText());
            serviceEntity.setDiscount(Double.parseDouble(discountField.getText()));
            serviceEntity.setImpPath(imgPathField.getText());

            try {
                serviceEntityManager.update(serviceEntity);
                mainForm.getModel().getValues().set(rowNumber, serviceEntity);
                mainForm.getModel().fireTableDataChanged();
                closeSubForm();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                DialogUtil.showError(this, "Ошибка сохранения услуги");
            }
        });
    }

    @Override
    public int getFormWidth() {
        return 500;
    }

    @Override
    public int getFormHeight() {
        return 500;
    }
}
