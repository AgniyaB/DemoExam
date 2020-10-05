package ru.pa4ok.demoexam;

public class Tiger extends Animal
{
    public Tiger()
    {
        super("млекопитающее", false);
    }

    @Override
    public String getSound() {
        return "рррр";
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "type='" + type + '\'' +
                ", isPet=" + isPet +
                '}';
    }
}
