package ru.pa4ok.demoexam;

public interface ISoundEntity
{
    //в интерфейсе нельзя размещать поля
    //private int a = 10;

    //заготовок функции (сразу абстрактная, без модификатора abstract)
    public String getSound();

    //уже реализованная функция, в интерфейсах у них обязателен модификатор default
    public default String doneFunction() {
        return "123";
    }
}
