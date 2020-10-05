package ru.pa4ok.demoexam;

public abstract class Animal extends EntityLiving
{
    protected int legsCount;
    protected boolean isPet;

    public Animal(int legsCount, boolean isPet) {
        this.legsCount = legsCount;
        this.isPet = isPet;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "legsCount=" + legsCount +
                ", isPet=" + isPet +
                '}';
    }

    public int getLegsCount() {
        return legsCount;
    }

    public void setLegsCount(int legsCount) {
        this.legsCount = legsCount;
    }

    public boolean isPet() {
        return isPet;
    }

    public void setPet(boolean pet) {
        isPet = pet;
    }
}
