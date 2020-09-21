package ru.pa4ok.demoexam;

public class Student
{
    private String name;
    private int id;
    private String surname;

    public Student(String name, int id, String surname)
    {
        this.name = name;
        this.id = id;
        this.surname = surname;
    }

    public Student(String name, String surname) {
        this(name, 2423, surname);
    }

    public Student(String name) {
        this(name, "УАЦАЦУаоцща");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", surname='" + surname + '\'' +
                '}';
    }

    public void print(String... strings)
    {
        for(String s : strings) {
            System.out.println(s);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

class PrivateStudent
{

}
