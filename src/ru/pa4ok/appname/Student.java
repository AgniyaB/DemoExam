package ru.pa4ok.appname;

public class Student
{
    private String firstname;
    private String surname;
    private int level;

    public Student(String firstname, String surname, int level) {
        this.firstname = firstname;
        this.surname = surname;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", level=" + level +
                '}';
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
