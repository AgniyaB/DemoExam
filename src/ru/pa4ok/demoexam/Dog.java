package ru.pa4ok.demoexam;

public class Dog extends EntityLiving implements ISoundEntity
{
    public Dog(String type, int age) {
        super(type, age);
    }

    @Override
    public String getSound() {
        return "гав";
    }

    @Override
    public String toString() {
        return "Dog{" +
                "type='" + type + '\'' +
                ", age=" + age +
                '}';
    }
}
