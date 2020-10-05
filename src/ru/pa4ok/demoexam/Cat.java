package ru.pa4ok.demoexam;

public class Cat extends Animal implements ISoundEntity
{
    public Cat() {
        super(4, true);
    }

    @Override
    public String getType() {
        return "млекопитающее";
    }

    @Override
    public String getSound() {
        return "мяу";
    }

    @Override
    public String toString() {
        return "Cat{" +
                "legsCount=" + legsCount +
                ", isPet=" + isPet +
                '}';
    }
}
