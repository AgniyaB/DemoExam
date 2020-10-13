package ru.pa4ok.demoexam;

public class Ant extends Animal
{
    public Ant() {
        super("насекомое", true, null);
    }

    @Override
    public String toString() {
        return "Ant{" +
                "canPet=" + canPet +
                ", hasSound=" + hasSound +
                ", sound='" + sound + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
