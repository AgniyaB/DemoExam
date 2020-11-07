package ru.pa4ok.demoexam.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseManager
{
    protected final MysqlDatabase database;

    public BaseManager(MysqlDatabase database) {
        this.database = database;
    }

    public int createTable(String name, String fields) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "CREATE TABLE IF NOT EXISTS " + name + " (" + fields + ");";
            Statement s = c.createStatement();

            return s.executeUpdate(sql);
        }
    }

    public int deleteTable(String name) throws SQLException
    {
        try(Connection c = database.getConnection())
        {
            String sql = "DELETE TABLE IF EXISTS " + name + ";";
            Statement s = c.createStatement();

            return s.executeUpdate(sql);
        }
    }

    public MysqlDatabase getDatabase() {
        return database;
    }
}
