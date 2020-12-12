package ru.pa4ok.appname.intrf.task;

public abstract class EntityLiving
{
    protected int age;

    public EntityLiving(int age) {
        this.age = age;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "EntityLiving{" +
                "age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
