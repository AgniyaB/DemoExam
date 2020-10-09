package ru.pa4ok.demoexam;

public class Bird extends EntityLiving implements ISoundEntity, IFlyEntity
{
    public Bird(String type, int age) {
        super(type, age);
    }

    @Override
    public int getMaxFlyHeight() {
        return 100;
    }

    @Override
    public String getSound() {
        return "кар";
    }
}
