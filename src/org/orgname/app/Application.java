package org.orgname.app;

import org.orgname.app.ui.ClientTableForm;
import org.orgname.app.util.*;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;

public class Application
{
    private static Application instance;

    private final MysqlDatabase database = new MysqlDatabase("116.202.236.174", "DemoExam", "DemoExam", "DemoExam");
    private static final String ADMIN_PASS = "0000";
    private static boolean adminMode = false;

    private Application()
    {
        instance = this;

        initDatabase();
        initUi();
        checkAdminMode();

        new ClientTableForm();
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
            BaseForm.setBaseApplicationIcon(ResourceUtil.getImage("icon.png"));
        } catch (IOException e) {
            e.printStackTrace();
            DialogUtil.showError("Не удалось загрузить иконку приложения");
        }

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        FontUtil.changeAllFonts(new FontUIResource("Lobster", Font.TRUETYPE_FONT, 16));
    }

    private void checkAdminMode()
    {
        adminMode = ADMIN_PASS.equals(JOptionPane.showInputDialog(
                null,
                "Введите пароль администратора если знаете",
                "Режим администратора",
                JOptionPane.QUESTION_MESSAGE
        ));
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

    public static boolean isAdminMode() {
        return adminMode;
    }

    public static void setAdminMode(boolean adminMode) {
        Application.adminMode = adminMode;
    }
}
