package ru.pa4ok.demoexam;

public class Tiger extends Predator
{
    public Tiger() {
        super("млекопитающее", "рррр");
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "canPet=" + canPet +
                ", hasSound=" + hasSound +
                ", sound='" + sound + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
