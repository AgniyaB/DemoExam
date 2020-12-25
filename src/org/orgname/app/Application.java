package org.orgname.app;

import org.orgname.app.ui.ClientTableForm;
import org.orgname.app.util.BaseForm;
import org.orgname.app.util.DialogUtil;
import org.orgname.app.util.FontUtil;
import org.orgname.app.util.MysqlDatabase;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.net.URL;
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

        new ClientTableForm();
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
        BaseForm.setBaseApplicationTitle("Медицинский центр ТРУБОЧИСТ");

        BaseForm.setBaseApplicationImage(
                Toolkit.getDefaultToolkit().getImage(
                        Application.class.getClassLoader().getResource("icom.jpg")
                )
        );

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        FontUtil.changeAllFonts(new FontUIResource("Comic Sans MS", Font.TRUETYPE_FONT, 16));
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
