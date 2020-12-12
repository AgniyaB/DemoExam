package ru.pa4ok.appname.abstr;

import ru.pa4ok.appname.Human;

public abstract class WorkerHuman extends Human
{
    public WorkerHuman(String firstname, String surname, boolean isWoman, int age)
    {
        super(firstname, surname, isWoman, age);
    }

    public abstract String getWorkInfo();

    public abstract void work();
}
