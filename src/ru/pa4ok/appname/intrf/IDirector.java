package ru.pa4ok.appname.intrf;

public interface IDirector extends IWorker
{
    public void pay(int count);

    @Override
    public default String getWorkInfo() {
        return "управляет компанией";
    }
}
