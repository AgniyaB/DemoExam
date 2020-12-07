package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.GenderEnum;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.DialogUtil;
import org.orgname.app.util.ObjectTableModel;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class ObjectTableForm extends BaseForm
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

    private ObjectTableModel<UserEntity> model;

    private JPanel mainPanel;
    private JTable table;

    public ObjectTableForm()
    {
        setContentPane(mainPanel);

        initTable();

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
                    new EditUserForm(ObjectTableForm.this, model.getRowEntity(row), row);
                }
            }
        });

        table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int row = table.getSelectedRow();
                if(e.getKeyCode() == KeyEvent.VK_DELETE && row != -1)
                {
                    if(DialogUtil.showConfirm(ObjectTableForm.this, "Вы точно хотите удалить данную запись?"))
                    {
                        UserEntity userEntity = model.getRowEntity(row);
                        try {
                            userEntityManager.deleteById(userEntity.getId());
                            model.removeRow(row);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
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

    @Override
    public int getFormWidth() {
        return 800;
    }

    @Override
    public int getFormHeight() {
        return 600;
    }

    public ObjectTableModel<UserEntity> getModel() {
        return model;
    }
}
