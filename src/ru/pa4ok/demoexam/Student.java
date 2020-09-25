package ru.pa4ok.demoexam;

public class Student
{
    public static final String CITY = "SPB";

    public static void testStatic()
    {
        System.out.println("test static");
    }

    private String name;
    private String surname;
    private int level;
    //private int[] integers = new int[10]; 10 нулей
    //private String[] strings = new String[10]; //10 null


    public Student(String name, String surname, int level) {
        this.name = name;
        this.surname = surname;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", level=" + level +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    /*public String[] getStrings() {
        return strings;
    }*/
}
