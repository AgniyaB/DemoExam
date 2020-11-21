package org.orgname.app;

import org.orgname.app.ui.TestForm;
import org.orgname.app.util.*;

import java.io.IOException;
import java.sql.Connection;

public class Application
{
    /*
    UserEntity
    - String login
    - String password
    - GenderEnum gender
    - int age
    - String job

    enum GenderEnum
    - MALE
    - FEMALE
     */

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
        try(Connection c = database.getConnection()) {
        } catch (Exception e) {
            DialogUtil.showError("Ошибка подлючения к бд");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private void initUi()
    {
        BaseForm.setBaseApplicationTitle("Медицинский центр трубочист");

        try {
            BaseForm.setBaseApplicationIcon(ResourceUtil.getImage("icon.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            DialogUtil.showError("Не удалось загрузить иконку приложения");
        }
    }

    public MysqlDatabase getDatabase() {
        return database;
    }

    public static Application getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        new Application();
    }
}
