package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.GenderEnum;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.DialogUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class TableForm extends BaseForm
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());
    private DefaultTableModel tableModel;

    private JPanel mainPanel;
    private JTable table;
    private JButton loadButton;
    private JButton addButton;

    public TableForm()
    {
        setContentPane(mainPanel);

        initTable();
        loadTableData();
        initButtons();

        setVisible(true);
    }

    private void initButtons()
    {
        loadButton.addActionListener(e -> {
            loadTableData();
        });

        addButton.addActionListener(e -> {
            new AddUserForm(this);
        });
    }

    private void initTable()
    {
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(tableModel);
        table.getTableHeader().setReorderingAllowed(false);

        tableModel.addColumn("id");
        tableModel.addColumn("login");
        tableModel.addColumn("password");
        tableModel.addColumn("gender");
        tableModel.addColumn("age");
        tableModel.addColumn("job");

        //получение записи по двойному клику
        table.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent mouseEvent)
            {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1)
                {
                    Object[] rowValues = new Object[tableModel.getColumnCount()];
                    for(int i=0; i<tableModel.getColumnCount(); i++) {
                        rowValues[i] = tableModel.getValueAt(row, i);
                    }

                    UserEntity user = new UserEntity(
                            (int)rowValues[0],
                            (String)rowValues[1],
                            (String)rowValues[2],
                            (GenderEnum)rowValues[3],
                            (int)rowValues[4],
                            (String)rowValues[5]
                    );
                    new EditUserForm(TableForm.this, user, row);
                }

                //установка значение по адресу
                //tableModel.setValueAt("new Login", 0, 1);
            }
        });
    }

    private void loadTableData()
    {
        try {
            List<UserEntity> users = userEntityManager.getAll();

            while (tableModel.getRowCount() > 0) {
                tableModel.removeRow(0);
            }

            for(UserEntity u : users)
            {
                tableModel.addRow(new Object[]{
                        u.getId(),
                        u.getLogin(),
                        u.getPassword(),
                        u.getGender(),
                        u.getAge(),
                        u.getJob()
                });
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            DialogUtil.showError("Не удалось загрузить данные");
        }
    }

    public void updateRow(int rowNumber, UserEntity user)
    {
        tableModel.setValueAt(user.getLogin(), rowNumber, 1);
        tableModel.setValueAt(user.getPassword(), rowNumber, 2);
        tableModel.setValueAt(user.getGender(), rowNumber, 3);
        tableModel.setValueAt(user.getAge(), rowNumber, 4);
        tableModel.setValueAt(user.getJob(), rowNumber, 5);
    }

    @Override
    public int getFormWidth() {
        return 800;
    }

    @Override
    public int getFormHeight() {
        return 400;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
