package ru.pa4ok.demoexam;

public class Dog extends EntityLiving implements ISoundEntity
{
    public Dog() {
        super("млекопитающее");
    }

    @Override
    public void test(int i) {
        System.out.println(i);
    }

    @Override
    public String getSound() {
        return "гав";
    }
}
