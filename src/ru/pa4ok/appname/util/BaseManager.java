package ru.pa4ok.appname.util;

public class BaseManager
{
    protected MysqlDatabase database;

    public BaseManager(MysqlDatabase database) {
        this.database = database;
    }

    public MysqlDatabase getDatabase() {
        return database;
    }

    public BaseManager setDatabase(MysqlDatabase database) {
        this.database = database;
        return this;
    }
}
