package ru.pa4ok.demoexam;

public class Ant extends Animal
{
    public Ant() {
        super(6, false);
    }

    @Override
    public String getType() {
        return "млекопитающее";
    }

    @Override
    public String toString() {
        return "Ant{" +
                "legsCount=" + legsCount +
                ", isPet=" + isPet +
                '}';
    }
}
