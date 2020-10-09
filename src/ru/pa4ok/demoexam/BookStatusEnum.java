package ru.pa4ok.demoexam;

public enum BookStatusEnum
{
    ON_HANDS("На руках", 1),
    IN_LIBRARY("В библиотеке", 2),
    IN_TRANSFER("В дороге", 3);

    private long dbStatus;
    private String translate;

    private BookStatusEnum(String translate, long dbStatus)
    {
        this.dbStatus = dbStatus;
        this.translate = translate;
    }

    @Override
    public String toString() {
        return translate;
    }

    public long getDbStatus() {
        return dbStatus;
    }

    public String getTranslate() {
        return translate;
    }
}
