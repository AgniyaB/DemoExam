package org.company.app.ui;

import org.company.app.Application;
import org.company.app.data.GenderEnum;
import org.company.app.data.entity.UserEntity;
import org.company.app.data.manager.UserEntityManager;
import org.company.app.util.BaseForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class TableForm extends BaseForm
{
    private final UserEntityManager userEntityManager = Application.getInstance().getUserEntityManager();

    private DefaultTableModel model;

    private JPanel mainPanel;
    private JTable table;
    private JButton loadButton;

    public TableForm()
    {
        setContentPane(mainPanel);

        initTable();
        initButtons();

        setVisible(true);
    }

    private void initTable()
    {
        table.getTableHeader().setReorderingAllowed(false);

        table.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent mouseEvent)
            {
                JTable table = (JTable)mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);

                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1)
                {
                    Object[] rowValues = new Object[table.getColumnCount()];
                    for(int i=0; i<table.getColumnCount(); i++) {
                        rowValues[i] = table.getValueAt(row, i);
                    }

                    UserEntity userEntity = new UserEntity(
                            (int)rowValues[0],
                            (String)rowValues[1],
                            (String)rowValues[2],
                            (GenderEnum)rowValues[3],
                            (int)rowValues[4],
                            (String)rowValues[5],
                            (String)rowValues[6]
                    );
                    System.out.println();
                    System.out.println("Row: " + row);
                    System.out.println("Entity: " + userEntity);
                }
            }
        });

        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(model);

        model.addColumn("ID");
        model.addColumn("Логин");
        model.addColumn("Пароль");
        model.addColumn("Гендер");
        model.addColumn("Возраст");
        model.addColumn("Работа");
        model.addColumn("Заметки");

        try {
            List<UserEntity> users = userEntityManager.getAll();
            users.forEach(user -> {
                model.addRow(new Object[] {
                        user.getId(),
                        user.getLogin(),
                        user.getPassword(),
                        user.getGender(),
                        user.getAge(),
                        user.getJob(),
                        user.getNotes()
                });
            });

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void initButtons()
    {
        loadButton.addActionListener(e -> {

        });
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
