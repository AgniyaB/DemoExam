package ru.pa4ok.demoexam;

public interface ISoundEntity
{
    //абстрактная функция
    public String getSound();

    //чтобы добавть реализованную функцию
    //нужен модификатор default
    public default void testDone()
    {
        System.out.println(1);
    }
}
