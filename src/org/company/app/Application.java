package org.company.app;

import org.company.app.data.manager.ClientEntityManager;
import org.company.app.ui.ClientTableForm;
import org.company.app.util.BaseForm;
import org.company.app.util.DialogUtil;
import org.company.app.util.FontUtil;
import org.company.app.util.MysqlDatabase;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Application
{
    private static Application instance;

    //private final MysqlDatabase database = new MysqlDatabase("nleontnr.beget.tech", "nleontnr_docker", "nleontnr_docker", "8udwX&9bdw");
    private final MysqlDatabase database = new MysqlDatabase("116.202.236.174", "DemoExam", "DemoExam", "DemoExam");
    private final ClientEntityManager clientEntityManager = new ClientEntityManager(database);
    private static final String ADMIN_PASS = "0000";
    private static boolean adminMode = false;

    public Application()
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
        } catch (SQLException e) {
            e.printStackTrace();
            DialogUtil.showError("Соедиение с базой установить не удалось");
            System.exit(228);
        }
    }

    private void initUi()
    {
        BaseForm.setBaseApplicationTitle("Медицинский центр трубочист");

        //не переваривает .ico файлы
        BaseForm.setBaseApplicationIcon(Toolkit.getDefaultToolkit().getImage(Application.class.getClassLoader().getResource("service_logo.png")));

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        FontUtil.changeAllFonts(new FontUIResource("Comic Sans MS", Font.TRUETYPE_FONT, 16));
    }

    private void checkAdminMode()
    {
        adminMode = ADMIN_PASS.equals(JOptionPane.showInputDialog(
                null,
                "Введите пароль админи если знаете",
                "Режим администратора",
                JOptionPane.QUESTION_MESSAGE
        ));
    }

    public MysqlDatabase getDatabase() {
        return database;
    }

    public ClientEntityManager getClientEntityManager() {
        return clientEntityManager;
    }

    public static void main(String[] args)
    {
        new Application();
    }

    public static Application getInstance() {
        return instance;
    }

    public static boolean isAdminMode() {
        return adminMode;
    }
}
