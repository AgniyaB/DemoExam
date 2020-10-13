package ru.pa4ok.demoexam;

public class Bird extends Animal
{
    public Bird(boolean canPet, String sound) {
        super("птица", canPet, sound);
    }

    @Override
    public String toString() {
        return "Bird{" +
                "canPet=" + canPet +
                ", hasSound=" + hasSound +
                ", sound='" + sound + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
