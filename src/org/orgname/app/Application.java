package org.orgname.app;

import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.ui.TestForm;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.MysqlDatabase;

public class Application
{
    private static Application instance;

    private final MysqlDatabase database = new MysqlDatabase("116.202.236.174", "DemoExam", "DemoExam", "DemoExam");

    private Application()
    {
        instance = this;

        initDatabase();
        initUi();

        new TestForm();
    }

    private void initDatabase()
    {

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
