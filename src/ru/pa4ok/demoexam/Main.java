package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        School school = new School(
            1,
            "fspo"/*,
                Arrays.asList(
                    new Teacher("jhfweewfw", "math"),
                    new Teacher("asedfqwe", "english")
                ),
                Arrays.asList(
                    new Student("vasya", 15, 4),
                    new Student("petya", 20, 11)
                )*/
        );
        System.out.println(school);
        school.getTeachers().add(new Teacher("jhfweewfw", "math"));
        school.getStudents().add(new Student("vasya", 15, 4));
        System.out.println(school);
    }

    /*
    все поля приватные
    +геттерыи и сеттеры

    School
    - int index
    - String name
    - List<Teacher> teachers
    - List<Student> students
    - toString()

    Student
    - String name
    - int age
    - int level
    - toString()

    Teacher
    - String name
    - String subject
    - toString()
     */
}
