package ru.pa4ok.demoexam;

public class Tiger extends Animal implements ISoundEntity
{
    public Tiger() {
        super(4, false);
    }

    @Override
    public String getSound() {
        return "ррррррр";
    }

    @Override
    public String getType() {
        return "млекопитающее";
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "legsCount=" + legsCount +
                ", isPet=" + isPet +
                '}';
    }
}
