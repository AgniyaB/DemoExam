package ru.pa4ok.demoexam;

public class Bird extends EntityLiving implements IFlyEntity, ISoundEntity
{
    public Bird() {
    }

    @Override
    public String getType() {
        return "млекопитающее";
    }

    @Override
    public boolean canPet() {
        return true;
    }

    @Override
    public int getMaxFlyTime() {
        return 100;
    }

    @Override
    public double getMaxFlyHeight() {
        return 30;
    }

    @Override
    public String getSound() {
        return "курлык";
    }

    @Override
    public String toString() {
        return "Bird{}";
    }
}
