package ru.pa4ok.demoexam;

import java.util.Arrays;

public class Task
{
    /*
        все поля в классах приватные
        + геттеры и сеттеры

        School
        - int number
        - String title
        - List<Teacher> teachers
        - List<Student> students
        - toString()

        Teacher
        - String name
        - String subject
        - toString()

        Student
        - String name
        - String surname
        - int level (class)
        - toString()
         */

    public static void main(String[] args)
    {
        School school = new School(
                5,
                "title",
                Arrays.asList(
                        new Teacher("teachc", "fgwefwefewf"),
                        new Teacher("ewrfwer", "wdrffwq")
                ),
                Arrays.asList(
                        new Student("543", 5),
                        new Student("aregfrewgewr", 4)
                )
        );
        System.out.println(school);
    }
}
