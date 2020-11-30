package org.orgname.app.ui;

import org.orgname.app.Application;
import org.orgname.app.database.entity.GenderEnum;
import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.BaseSubForm;
import org.orgname.app.util.ObjectTableModel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class UsersListForm extends BaseSubForm<MainForm>
{
    private final UserEntityManager userEntityManager = new UserEntityManager(Application.getInstance().getDatabase());

    private ObjectTableModel<UserEntity> model;

    private JPanel mainPanel;
    private JTable table;
    private JButton idSortButton;
    private JButton ageSortButton;

    private boolean idSort;
    private boolean ageSort;

    public UsersListForm(MainForm mainForm)
    {
        super(mainForm);
        setContentPane(mainPanel);

        initTable();
        initButtons();

        setVisible(true);
    }

    private void initTable()
    {
        table.getTableHeader().setReorderingAllowed(false);

        model = new ObjectTableModel<UserEntity>()
        {
            @Override
            public UserEntity getEntityFromData(Object[] columns) {
                return new UserEntity(
                        (int)columns[0],
                        (String)columns[1],
                        (String)columns[2],
                        (GenderEnum)columns[3],
                        (int)columns[4],
                        (String)columns[5]
                );
            }

            @Override
            public Object[] getDataFromEntity(UserEntity u) {
                return new Object[]{
                        u.getId(),
                        u.getLogin(),
                        u.getPassword(),
                        u.getGender(),
                        u.getAge(),
                        u.getJob()
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
            List<UserEntity> users = userEntityManager.getAll();
            for(UserEntity u : users) {
                model.addRow(u);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent mouseEvent)
            {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);

                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    System.out.println(model.getEntity(row));
                }
            }
        });
    }

    private void initButtons()
    {
        idSortButton.addActionListener(e -> {
            model.sort(new Comparator<UserEntity>() {
                @Override
                public int compare(UserEntity o1, UserEntity o2) {
                    if(idSort) {
                        return Integer.compare(o2.getId(), o1.getId());
                    } else {
                        return Integer.compare(o1.getId(), o2.getId());
                    }
                }
            });
            idSort = !idSort;
        });

        ageSortButton.addActionListener(e -> {
            model.sort(new Comparator<UserEntity>() {
                @Override
                public int compare(UserEntity o1, UserEntity o2) {
                    if(ageSort) {
                        return Integer.compare(o2.getAge(), o1.getAge());
                    } else {
                        return Integer.compare(o1.getAge(), o2.getAge());
                    }
                }
            });
            ageSort = !ageSort;
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
