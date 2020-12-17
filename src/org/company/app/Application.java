package org.company.app;

import org.company.app.data.entity.DateEntity;
import org.company.app.data.manager.DateEntityManager;
import org.company.app.data.manager.UserEntityManager;
import org.company.app.ui.service.ServiceTableForm;
import org.company.app.ui.user.CustomTableForm;
import org.company.app.util.BaseForm;
import org.company.app.util.DialogUtil;
import org.company.app.util.MysqlDatabase;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Application
{
    private static Application instance;

    private final MysqlDatabase database = new MysqlDatabase("116.202.236.174", "DemoExam", "DemoExam", "DemoExam");
    //private final MysqlDatabase database = new MysqlDatabase("nleontnr.beget.tech", "nleontnr_docker", "nleontnr_docker", "8udwX&9bdw");

    private final UserEntityManager userEntityManager = new UserEntityManager(database);

    public Application()
    {
        instance = this;

        initDatabase();
        initUi();

        String birthday = "18.07.2000";
        SimpleDateFormat format3 = new SimpleDateFormat("dd.MM.yyyy");
        try {
            DateEntityManager dateEntityManager = new DateEntityManager(database);
            DateEntity dateEntity = new DateEntity(format3.parse(birthday));
            dateEntityManager.add(dateEntity);
            System.out.println(dateEntity);
        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }

        //new ServiceTableForm();
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
