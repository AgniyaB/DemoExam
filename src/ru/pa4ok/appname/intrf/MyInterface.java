package ru.pa4ok.appname.intrf;

public interface MyInterface
{
    //абстрактный метод
    //так как это интерфейс
    //то все методы без тела по умолчанию абстрактные
    public int test(int a);

    //чтобы добавить реализованный метод нужно воспользоваться модификатором default
    public default int testDone(int a) {
        return a * 10;
    }
}
