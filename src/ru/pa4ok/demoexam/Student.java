package ru.pa4ok.demoexam;

public class Student extends Human
{
    private int level;

    public Student(String name, int age, boolean isWomen, int level) {
        super(name, age, isWomen);
        this.level = level;
    }

    @Override
    public String toString() {
        return "Student{" +
                "level=" + level +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isWomen=" + isWomen +
                '}';
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
