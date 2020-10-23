package ru.pa4ok.demoexam;

public enum GenderEnum
{
    MALE("МУЖЧИНА"),
    FEMALE("ЖЕНЩИНА");

    private final String translate;

    //только private конструктор
    private GenderEnum(String translate)
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
