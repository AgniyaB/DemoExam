package ru.pa4ok.demoexam;

public class Cat extends Animal
{
    public Cat()
    {
        super("млекопитающее", true);
    }

    @Override
    public void updateEntity()
    {
        super.updateEntity();
        System.out.println("update from Cat");
    }

    @Override
    public String getSound() {
        return "мау";
    }

    @Override
    public String toString() {
        return "Cat{" +
                "type='" + type + '\'' +
                ", isPet=" + isPet +
                '}';
    }
}
