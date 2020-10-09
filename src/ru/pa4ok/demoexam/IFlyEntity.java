package ru.pa4ok.demoexam;

public interface IFlyEntity
{
    public int getMaxFlyHeight();

    //можно сделать дефолтную функцию, а не заготовку
    public default int getSpeed() {
        return 10;
    }
}
