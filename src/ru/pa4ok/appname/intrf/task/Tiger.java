package ru.pa4ok.appname.intrf.task;

public class Tiger extends EntityLiving implements ISoundEntity
{
    public Tiger(int age) {
        super(age);
    }

    @Override
    public String getType() {
        return "млекопитающее";
    }

    @Override
    public String getSound() {
        return "рррррррррррр";
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "age=" + age +
                '}';
    }
}
