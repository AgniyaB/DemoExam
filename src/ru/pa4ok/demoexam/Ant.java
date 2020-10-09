package ru.pa4ok.demoexam;

public class Ant extends EntityLiving
{
    public Ant() {
    }

    @Override
    public String getType() {
        return "насекомое";
    }

    @Override
    public boolean canPet() {
        return false;
    }

    @Override
    public String toString() {
        return "Ant{}";
    }
}
