package org.company.app;

import org.company.app.data.manager.UserEntityManager;
import org.company.app.ui.CustomTableForm;
import org.company.app.util.BaseForm;
import org.company.app.util.DialogUtil;
import org.company.app.util.MysqlDatabase;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Application
{
    private static Application instance;

    private final MysqlDatabase database = new MysqlDatabase("116.202.236.174", "DemoExam", "DemoExam", "DemoExam");
    private final UserEntityManager userEntityManager = new UserEntityManager(database);

    public Application()
    {
        instance = this;

        initDatabase();
        initUi();

        new CustomTableForm();
        //new StartForm();
    }

    private void initDatabase()
    {
        try(Connection c = database.getConnection()) {
        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError("Соедиение с базой установить не удалось");
            System.exit(228);
        }
    }

    private void initUi()
    {
        BaseForm.setBaseApplicationTitle("Медицинский центр трубочист");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MysqlDatabase getDatabase() {
        return database;
    }

    public UserEntityManager getUserEntityManager() {
        return userEntityManager;
    }

    public static void main(String[] args)
    {
        new Application();
    }

    public static Application getInstance() {
        return instance;
    }
}
