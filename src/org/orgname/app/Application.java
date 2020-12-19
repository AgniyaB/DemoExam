package org.orgname.app;

import org.orgname.app.ui.CustomTableForm;
import org.orgname.app.ui.ServiceTableForm;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.DialogUtil;
import org.orgname.app.util.MysqlDatabase;

import javax.swing.*;
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

        new ServiceTableForm();
    }

    private void initDatabase()
    {
        try(Connection c = database.getConnection()) {
        } catch (Exception e) {
            DialogUtil.showError("Ошибка подключения к бд");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private void initUi()
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

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
