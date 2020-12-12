package ru.pa4ok.appname;

public class Student extends Human //наследуем класс Human
{
    private int level;

    public Student(String firstname, String surname, boolean isWoman, int age, int level) {
        super(firstname, surname, isWoman, age); //вызов родительского конструктора
        this.level = level;
    }

    @Override
    public void work()
    {
        super.work(); //вызов родительской реализации метода work()
        System.out.println("work from Student");
    }

    @Override
    public String toString() {
        return "Student{" +
                "level=" + level +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", isWoman=" + isWoman +
                ", age=" + age +
                '}';
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
