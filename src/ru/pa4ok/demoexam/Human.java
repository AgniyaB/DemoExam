package ru.pa4ok.demoexam;

public class Human
{
    protected String name;
    protected int age;
    protected boolean isWomen;

    public Human(String name, int age, boolean isWomen) {
        this.name = name;
        this.age = age;
        this.isWomen = isWomen;
    }

    public void nextYear() {
        age++;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isWomen=" + isWomen +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isWomen() {
        return isWomen;
    }

    public void setWomen(boolean women) {
        isWomen = women;
    }
}
