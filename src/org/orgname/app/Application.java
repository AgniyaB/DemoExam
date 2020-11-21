package org.orgname.app;

import org.orgname.app.ui.TestForm;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.MysqlDatabase;

import java.sql.Connection;

public class Application
{
    private static Application instance;

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

        new TestForm();
    }

    private void initDatabase()
    {
        try(Connection c = database.getConnection()) {
        } catch (Exception e) {
            System.out.println("Ошибка подключения к бд");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private void initUi()
    {
        BaseForm.setBaseApplicationTitle("Медицинский центр ТРУБОЧИСТ");
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
