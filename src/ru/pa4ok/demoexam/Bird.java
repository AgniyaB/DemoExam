package ru.pa4ok.demoexam;

public class Bird extends Animal implements ISoundEntity, IFlyAnimal
{
    public Bird() {
        super(2, false);
    }

    @Override
    public String getType() {
        return "млекопитающее";
    }

    @Override
    public int getMaxFlyHeight() {
        return 100;
    }

    @Override
    public String getSound() {
        return "чирик-чирик";
    }

    @Override
    public String toString() {
        return "Bird{" +
                "legsCount=" + legsCount +
                ", isPet=" + isPet +
                '}';
    }
}
