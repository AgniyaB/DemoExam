package ru.pa4ok.demoexam;

public class Tiger extends EntityLiving implements ISoundEntity
{
    public Tiger() {
    }

    @Override
    public String getType() {
        return "млекопитающее";
    }

    @Override
    public boolean canPet() {
        return false;
    }

    @Override
    public String getSound() {
        return "ррррр";
    }

    @Override
    public String toString() {
        return "Tiger{}";
    }


}
