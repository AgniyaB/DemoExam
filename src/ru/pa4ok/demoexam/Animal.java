package ru.pa4ok.demoexam;

public class Animal
{
    protected String type;
    protected boolean isPet;

    public Animal(String type, boolean isPet) {
        this.type = type;
        this.isPet = isPet;
    }

    public void updateEntity()
    {
        System.out.println("update from Animal");
    }

    public String getSound() {
        return null;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", isPet=" + isPet +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPet() {
        return isPet;
    }

    public void setPet(boolean pet) {
        isPet = pet;
    }
}
