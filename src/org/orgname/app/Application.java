package org.orgname.app;

import org.orgname.app.database.entity.DateEntity;
import org.orgname.app.database.manager.DateEntityManager;
import org.orgname.app.ui.CustomTableForm;
import org.orgname.app.ui.ObjectTableForm;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.DialogUtil;
import org.orgname.app.util.MysqlDatabase;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class Application
{
    private static Application instance;

    private final MysqlDatabase database = new MysqlDatabase("116.202.236.174", "DemoExam", "DemoExam", "DemoExam");

    private Application()
    {
        instance = this;

        initUi();
        initDatabase();

        /*DateEntity dateEntity = new DateEntity(new Date());
        DateEntityManager dateEntityManager = new DateEntityManager(database);
        try {
            dateEntityManager.add(dateEntity);
            System.out.println(dateEntity);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

        new CustomTableForm();
        //new ObjectTableForm();
    }

    private void initDatabase()
    {
        try(Connection c = database.getConnection()) {
        } catch (Exception e) {
            e.printStackTrace();
            DialogUtil.showError("Ошибка подключения к бд");
            System.exit(-1);
        }
    }

    private void initUi()
    {
        BaseForm.setBaseApplicationTitle("Медицинский центр ТРУБОЧИСТ");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MysqlDatabase getDatabase() {
        return database;
    }

    public static Application getInstance() {
        return instance;
    }

    public static void main(String[] args)
    {
        new Application();
    }
}
