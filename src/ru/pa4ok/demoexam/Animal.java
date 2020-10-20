package ru.pa4ok.demoexam;

public class Animal extends EntityLiving
{
    public Animal(String type) {
        super(type);
    }

    @Override
    public void test(int i) {
        System.out.println(i);
    }
}
