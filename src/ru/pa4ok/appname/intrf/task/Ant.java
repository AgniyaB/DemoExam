package ru.pa4ok.appname.intrf.task;

public class Ant extends EntityLiving
{
    public Ant(int age) {
        super(age);
    }

    @Override
    public String getType() {
        return "насекомое";
    }

    @Override
    public String toString() {
        return "Ant{" +
                "age=" + age +
                '}';
    }
}
