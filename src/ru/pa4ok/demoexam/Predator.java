package ru.pa4ok.demoexam;

public class Predator extends Animal
{
    public Predator(String type, String sound) {
        super(type, false, sound);
    }

    @Override
    public String toString() {
        return "Predator{" +
                "canPet=" + canPet +
                ", hasSound=" + hasSound +
                ", sound='" + sound + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
