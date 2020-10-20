package ru.pa4ok.demoexam;

public class Bird extends EntityLiving implements ISoundEntity, IFlyEntity
{
    public Bird() {
        super("птицы");
    }

    @Override
    public void test(int i) {
        System.out.println(2);
    }

    @Override
    public int getMaxFlyHeight() {
        return 100;
    }

    @Override
    public String getSound() {
        return "курлык";
    }
}
