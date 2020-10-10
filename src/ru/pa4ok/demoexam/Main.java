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
                "spo",
                new ArrayList<>(Arrays.asList(
                        new Teacher("grin4pun", "pp"),
                        new Teacher("grin4pun", "pp")
                )),
                new ArrayList<>(Arrays.asList(
                        new Student("vasya", 5),
                        new Student("petya", 6)
                ))
        );

        //school.getTeachers().add(new Teacher("grin4pun", "pp"));

        System.out.println(school);
    }

    /*//примерная реализация Arrays.asList(...)
    private static <T> List<T> myAsList(T... objs)
    {
        List<T> list = new ArrayList<>();
        for(T t : objs) {
            list.add(t);
        }
        return list;
    }*/

    /*
    все поля приватные
    + геттеры и сеттеры

    Student
    - String name
    - int level
    - toString()

    Teacher
    - String name
    - String subject
    - toString()

    School
    - int index
    - String name
    - List<Teacher> teachers
    - List<Student> students
    - toString()
     */
}

