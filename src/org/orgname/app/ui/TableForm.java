package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.GenderEnum;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.ObjectTableModel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class TableForm extends BaseForm
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

    private ObjectTableModel<UserEntity> model;

    private JPanel mainPanel;
    private JTable table;

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

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && table.getSelectedRow() != -1)
                {
                    int row = table.rowAtPoint(e.getPoint());
                    System.out.println(model.getRowEntity(row));
                }
            }
        });

        model = new ObjectTableModel<UserEntity>() {
            @Override
            public UserEntity getEntityFromRowData(Object[] rowData) {
                return new UserEntity(
                        (int)rowData[0],
                        (String)rowData[1],
                        (String)rowData[2],
                        (GenderEnum)rowData[3],
                        (int)rowData[4],
                        (String)rowData[5]
                );
            }

            @Override
            public Object[] getRowDataFromEntity(UserEntity entity) {
                return new Object[] {
                        entity.getId(),
                        entity.getLogin(),
                        entity.getPass(),
                        entity.getGender(),
                        entity.getAge(),
                        entity.getJob()
                };
            }
        };
        table.setModel(model);

        model.addColumn("ID");
        model.addColumn("Логин");
        model.addColumn("Пароль");
        model.addColumn("Гендер");
        model.addColumn("Возраст");
        model.addColumn("Работа");

        try {
            model.addRowEntities(userEntityManager.getAll());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void initButtons()
    {

    }

    @Override
    public int getFormWidth() {
        return 800;
    }

    @Override
    public int getFormHeight() {
        return 600;
    }
}
