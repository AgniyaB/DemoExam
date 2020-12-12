package ru.pa4ok.appname.abstr;

public abstract class SomeAbstractClass
{
    public SomeAbstractClass()
    {

    }

    //абстрактная функция
    //она не реализована
    //такие функции не могут находится в обычном классе
    public abstract void work();

    public static void main(String[] args)
    {
        //new SomeAbstractClass();
        //у абстрактного класса нельзя создать напрямую объект

        new AbstractExtender();
        //можно унаследовать его и создать объект
    }
}

//если обычный класс наследует абстрактный с нереализовнными функциями
//то он обязан их реализовать
class AbstractExtender extends SomeAbstractClass
{
    public AbstractExtender() {
    }

    @Override
    public void work() {
        System.out.println("work");
    }
}