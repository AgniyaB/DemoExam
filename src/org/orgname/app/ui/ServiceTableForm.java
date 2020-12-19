package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.ServiceEntity;
import org.orgname.app.database.manager.ServiceEntityManager;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.CustomTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;

public class ServiceTableForm extends BaseForm
{
    private final ServiceEntityManager serviceEntityManager = Application.getInstance().serviceEntityManager;

    private CustomTableModel<ServiceEntity> model;

    private boolean discountSort = false;

    private JPanel mainPanel;
    private JTable table;
    private JButton discountSortButton;
    private JComboBox discountSortBox;
    private JButton clearButton;

    public ServiceTableForm()
    {
        setContentPane(mainPanel);

        initTable();
        initBoxes();
        initButtons();

        setVisible(true);
    }

    private void initTable()
    {
        try {
            model = new CustomTableModel<>(
                    ServiceEntity.class,
                    new String[] {
                            "ID", "Наименование", "Стоимость", "Продолжительность", "Скидка", "Миниатюра"
                    },
                    serviceEntityManager.getAll()
            );
            table.setModel(model);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
            {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                ServiceEntity service = model.getValues().get(row);
                c.setBackground(service.getDiscount() > 0 ?  new Color(144, 238, 144) : Color.WHITE);
                return c;
            }
        });
    }

    private void initBoxes()
    {
        discountSortBox.addItem("от 0 до 5%");
        discountSortBox.addItem("от 5% до 15%");
        discountSortBox.addItem("от 15% до 30%");
        discountSortBox.addItem("от 30% до 70%");
        discountSortBox.addItem("от 70% до 100%");
    }

    private void initButtons()
    {
        discountSortButton.addActionListener(e -> {
            Collections.sort(model.getValues(), new Comparator<ServiceEntity>() {
                @Override
                public int compare(ServiceEntity o1, ServiceEntity o2) {
                    if(!discountSort) {
                        return Double.compare(o1.getDiscount(), o2.getDiscount());
                    } else {
                        return Double.compare(o2.getDiscount(), o1.getDiscount());
                    }
                }
            });
            discountSort = !discountSort;
            model.fireTableDataChanged();
        });

        clearButton.addActionListener(e -> {
            try {
                model.setValues(serviceEntityManager.getAll());
                model.fireTableDataChanged();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @Override
    public int getFormWidth() {
        return 1000;
    }

    @Override
    public int getFormHeight() {
        return 600;
    }

    public CustomTableModel<ServiceEntity> getModel() {
        return model;
    }
}
