package ru.pa4ok.appname.util;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/*
    класс который описывает и инициализирует пул соденений с бд
    а также предоставлят метод для их получения
 */
public class MysqlDatabase
{
    //переменные для инициализации пула
    private String address;
    private int port;
    private String db;
    private String user;
    private String pass;
    //

    //непосредственно сам пул
    private MysqlDataSource source;

    public MysqlDatabase(String address, int port, String db, String user, String pass) {
        this.address = address;
        this.port = port;
        this.db = db;
        this.user = user;
        this.pass = pass;
    }

    public Connection getConnection() throws SQLException
    {
        if(source == null)
        {
            source = new MysqlDataSource();

            source.setServerName(address);
            source.setPort(port);
            source.setDatabaseName(db);
            source.setUser(user);
            source.setPassword(pass);

            source.setCharacterEncoding("UTF-8");
            source.setServerTimezone("UTC");
        }

        return source.getConnection();
    }

    public MysqlDatabase(String address, String db, String user, String pass) {
        this(address, 3306, db, user, pass);
    }

    public String getAddress() {
        return address;
    }

    public MysqlDatabase setAddress(String address) {
        this.address = address;
        return this;
    }

    public int getPort() {
        return port;
    }

    public MysqlDatabase setPort(int port) {
        this.port = port;
        return this;
    }

    public String getDb() {
        return db;
    }

    public MysqlDatabase setDb(String db) {
        this.db = db;
        return this;
    }

    public String getUser() {
        return user;
    }

    public MysqlDatabase setUser(String user) {
        this.user = user;
        return this;
    }

    public String getPass() {
        return pass;
    }

    public MysqlDatabase setPass(String pass) {
        this.pass = pass;
        return this;
    }
}
