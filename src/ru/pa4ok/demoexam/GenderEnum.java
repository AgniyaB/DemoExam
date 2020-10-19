package ru.pa4ok.demoexam;

public enum GenderEnum
{
    MALE("Мужчина"),
    FEMALE("Женщина");

    private final String translate;

    //только приватный конструктор
    private GenderEnum(String translate)
    {
        this.translate = translate;
    }

    @Override
    public String toString() {
        return this.translate.toUpperCase();
    }

    public String getTranslate() {
        return translate;
    }
}
