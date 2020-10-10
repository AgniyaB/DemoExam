package ru.pa4ok.demoexam;

public enum BookStatusEnum
{
    IN_LIBRARY("в библиотеке"),
    ON_HANDS("на руках"),
    IN_TRANSFER("в дороге");

    private final String translate;

    private BookStatusEnum(String translate)
    {
        this.translate = translate;
    }

    @Override
    public String toString() {
        return this.translate;
    }

    public String getTranslate() {
        return translate;
    }
}
