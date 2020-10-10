package ru.pa4ok.demoexam;

public class Ant extends EntityLiving
{
    public Ant(String type, int age) {
        super(type, age);
    }

    @Override
    public String toString() {
        return "Ant{" +
                "type='" + type + '\'' +
                ", age=" + age +
                '}';
    }
}
