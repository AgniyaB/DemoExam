package ru.pa4ok.demoexam.util;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MysqlDatabase
{
    private final String serverName;
    private final int port;
    private final String dbName;
    private final String user;
    private final String pass;

    private DataSource dataSource;

    public MysqlDatabase(String serverName, int port, String dbName, String user, String pass) {
        this.serverName = serverName;
        this.port = port;
        this.dbName = dbName;
        this.user = user;
        this.pass = pass;
    }

    public Connection getConnection() throws SQLException
    {
        if(this.dataSource == null) {
            MysqlDataSource mysqlDataSource = new MysqlDataSource();

            mysqlDataSource.setServerName(serverName);
            mysqlDataSource.setPort(port);
            mysqlDataSource.setDatabaseName(dbName);
            mysqlDataSource.setUser(user);
            mysqlDataSource.setPassword(pass);

            mysqlDataSource.setCharacterEncoding("UTF-8");
            mysqlDataSource.setServerTimezone("UTC");

            this.dataSource = mysqlDataSource;
        }

        return this.dataSource.getConnection();
    }

    public String getServerName() {
        return serverName;
    }

    public int getPort() {
        return port;
    }

    public String getDbName() {
        return dbName;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}
