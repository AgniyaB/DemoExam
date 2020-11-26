package org.orgname.app;

import org.orgname.app.ui.TestForm;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.MysqlDatabase;

public class Main
{
    private static Main instance;

    private final MysqlDatabase database = new MysqlDatabase("116.202.236.174", "DemoExam", "DemoExam", "DemoExam");

    private Main()
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

    public static Main getInstance() {
        return instance;
    }

    public static void main(String[] args)
    {
        new Main();
    }
}
