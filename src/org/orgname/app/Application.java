package org.orgname.app;

import org.orgname.app.database.entity.DateEntity;
import org.orgname.app.database.manager.DateEntityManager;
import org.orgname.app.ui.UsersTableForm;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.MysqlDatabase;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Application
{
    private static Application instance;

    private final MysqlDatabase database = new MysqlDatabase("116.202.236.174", "DemoExam", "DemoExam", "DemoExam");

    private Application()
    {
        instance = this;

        initDatabase();
        initUi();

        try {
            test();
        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }

        //new UsersTableForm();
    }

    private void test() throws ParseException, SQLException
    {
        String birthday = "18.07.2000";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        DateEntity dateEntity = new DateEntity(dateFormat.parse(birthday));
        DateEntityManager dateEntityManager = new DateEntityManager(database);
        dateEntityManager.add(dateEntity);
        System.out.println(dateEntity);
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

    public static void main(String[] args)
    {
        new Application();
    }

    public static Application getInstance() {
        return instance;
    }
}
