package ru.pa4ok.demoexam;

public interface ISoundEntity
{
    public void writeSound();

    //реализованная функция
    public default void doneFunction() {
        System.out.println("test");
    }
}
