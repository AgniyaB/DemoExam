package ru.pa4ok.demoexam;

public class Main
{
    public static void main(String[] args)
    {
        School school = new School(
            1,
            "fspo",
            new Teacher[] {
                    new Teacher("jhfweewfw", "math"),
                    new Teacher("asedfqwe", "english")
            },
            new Student[] {
                    new Student("vasya", 15, 4),
                    new Student("petya", 20, 11)
            }
        );
        System.out.println(school);

        School school1 = new School(2, "polikek");
        System.out.println(school1);
        System.out.println(school1.getStudents().length);

        Teacher teacher = new Teacher("kolya", "de");
        school1.getTeachers()[0] = teacher;
        System.out.println(school1);
        teacher.setName("fewfwefefw");
        System.out.println(school1);
    }

    /*
    все поля приватные
    +геттерыи и сеттеры

    School
    - int index
    - String name
    - Teacher[2] teachers
    - Student[2] students
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
