package org.orgname.app.util;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MysqlDatabase
{
    private final String address;
    private final int port;
    private final String name;
    private final String user;
    private final String pass;

    private DataSource source;

    public MysqlDatabase(String address, int port, String name, String user, String pass)
    {
        this.address = address;
        this.port = port;
        this.name = name;
        this.user = user;
        this.pass = pass;
    }

    public MysqlDatabase(String address, String name, String user, String pass) {
        this(address, 3306, name, user, pass);
    }

    public Connection getConnection() throws SQLException
    {
        if(source == null) {
            MysqlDataSource mysqlDataSource = new MysqlDataSource();

            mysqlDataSource.setServerName(address);
            mysqlDataSource.setPort(port);
            mysqlDataSource.setDatabaseName(name);
            mysqlDataSource.setUser(user);
            mysqlDataSource.setPassword(pass);

            mysqlDataSource.setCharacterEncoding("UTF-8");
            mysqlDataSource.setServerTimezone("UTC");

            this.source = mysqlDataSource;
        }

        return this.source.getConnection();
    }

    public String getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}
