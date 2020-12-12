package ru.pa4ok.appname.intrf.task;

public class Pigeon extends EntityLiving implements ISoundEntity, IFlyEntity
{
    public Pigeon(int age) {
        super(age);
    }

    @Override
    public String getType() {
        return "птицы";
    }

    @Override
    public int getMaxFlyHeight() {
        return 100;
    }

    @Override
    public int getMaxFlyTime() {
        return 60;
    }

    @Override
    public String getSound() {
        return "курлык";
    }

    @Override
    public String toString() {
        return "Pigeon{" +
                "age=" + age +
                '}';
    }
}
