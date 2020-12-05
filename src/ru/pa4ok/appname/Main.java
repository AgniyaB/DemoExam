package ru.pa4ok.appname;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    /*
    Student
    - String surname
    - String firstname
    - int level //класс

    Teacher
    - String surname
    - String firstname
    - int exp //стаж

    School
    - int number
    - String title
    - List<Teacher> teachers
    - List<Student> students

    у всех классов переопределен метод toString()
    все поля приватные + геттеры и сеттеры
    создать объект школы со студертами и учителями
    вывести его в консоль
     */

    public static void main(String[] args)
    {
        School school = new School(1, "первая школа кибербулинга");

        school.getTeachers().add(new Teacher("кибербулер", "228","кибербуллинг", 10));
        school.getTeachers().add(new Teacher("кибербулер", "228","кибербуллинг", 10));
        school.getTeachers().add(new Teacher("кибербулер", "228","кибербуллинг", 10));

        school.getStudents().add(new Student("vasya", "kolpin", 15));
        school.getStudents().add(new Student("vasya", "kolpin", 15));
        school.getStudents().add(new Student("vasya", "kolpin", 15));

        System.out.println(school);
    }
}
