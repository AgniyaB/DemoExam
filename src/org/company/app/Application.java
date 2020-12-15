package org.company.app;

import org.company.app.ui.UsersTableForm;
import org.company.app.util.BaseForm;
import org.company.app.util.MysqlDatabase;

import javax.swing.*;
import java.sql.Connection;

public class Application
{
    private static Application instance;

    public static void main(String[] args)
    {
        new Application();
    }

    private final MysqlDatabase database = new MysqlDatabase(
            "116.202.236.174",
            "DemoExam",
            "DemoExam",
            "DemoExam"
    );

    private Application()
    {
        instance = this;

        initDatabase();
        initUi();

        new UsersTableForm();
    }

    private void initDatabase()
    {
        try(Connection c = database.getConnection()) {
        } catch (Exception e) {
            System.out.println("Ошибка подключения к базе");
            e.printStackTrace();
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
}
