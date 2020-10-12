package ru.pa4ok.demoexam;

public class Student extends Human
{
    private int level;

    public Student(String name, int age, Gender gender, int level) {
        super(name, age, gender);
        this.level = level;
    }

    @Override
    public String toString() {
        return "Student{" +
                "level=" + level +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
