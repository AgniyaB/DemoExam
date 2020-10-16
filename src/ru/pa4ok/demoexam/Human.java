package ru.pa4ok.demoexam;

public class Human
{
    protected String name;
    protected int age;
    protected boolean isWoman;

    public Human(String name, int age, boolean isWoman) {
        this.name = name;
        this.age = age;
        this.isWoman = isWoman;
    }

    public void nextYear() {
        age++;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isWoman=" + isWoman +
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

    public boolean isWoman() {
        return isWoman;
    }

    public void setWoman(boolean woman) {
        isWoman = woman;
    }
}
