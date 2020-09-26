package ru.pa4ok.demoexam.school;

public class Main
{
    public static void main(String[] args)
    {
        /*Teacher[] teachers = {
            new Teacher("teacher1", "math"),
            new Teacher("teacher2", "fizra")
        };

        Student[] students = {
                new Student("vasya", 4),
                new Student("Petya", 6)
        };*/

        School school = new School(
            228,
            "школа 228",
            new Teacher[] {
                    new Teacher("teacher1", "math"),
                    new Teacher("teacher2", "fizra")
            },
            new Student[] {
                    new Student("vasya", 4),
                    new Student("Petya", 6)
            }
        );

        System.out.println(school);
    }

    /*
    все поля приватные
    наличие геттеров и сеттеров
    создать объет школы, заполнить данными
    вывести школу в консоль

    School
    - int index
    - String title
    - Teacher[2]
    - Student[4]

    Student
    - String name
    - int level
    - toString()

    Teacher
    - String name
    - String subject
    - toString()
     */
}
