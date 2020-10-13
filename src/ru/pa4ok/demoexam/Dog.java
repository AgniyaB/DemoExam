package ru.pa4ok.demoexam;

public class Dog extends Animal
{
    private String name;

    public Dog(String name) {
        super("млекопитающее", true, "гав");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", canPet=" + canPet +
                ", hasSound=" + hasSound +
                ", sound='" + sound + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
