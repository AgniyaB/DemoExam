package org.orgname.app.ui;

import org.orgname.app.Application;
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
                    System.out.println(Arrays.toString(rowValues));
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

    @Override
    public int getFormWidth() {
        return 500;
    }

    @Override
    public int getFormHeight() {
        return 300;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
