package ru.pa4ok.demoexam.shool;

public class Main
{
    public static void main(String[] args)
    {
        /*School school = new School(
                1,
                "fspo",
                new Teacher[] {
                        new Teacher("grin4pun", "pp"),
                        new Teacher("wefewefw", "efwewf")
                },
                new Student[] {
                        new Student("Vasya", 15, 5),
                        new Student("Petya", 13, 3)
                }
        );

        *//*Teacher[] teachers = {new Teacher("grin4pun", "pp"),
                new Teacher("wefewefw", "efwewf")};*//*

        System.out.println(school);*/

       /* System.out.println(Student.CITY);
        Student.testStatic();

        System.out.println(Math.PI);
        System.out.println(Math.cos(Math.PI));

        Student s = new Student("Vasya", 15, 5);
        System.out.println(s.CITY); //обращаться к статике из объекта некорректно*/

        School school1 = new School("first");
        School school2 = new School("second");
        System.out.println(school1);
        System.out.println(school2);
    }

    /*
    все поля private
    +геттеры и сеттеры

    Student
    - String name
    - int age
    - int level
    - toString()

    Teacher
    - String name
    - String subject
    - toString()

    School
    - static int INDEX_COUNTER
    - int index
    - String name
    - Teacher[] teacher //поля с вашими типами
    - Student[] student
    - toString()

    создать объект школы и заполнить все поля
    вывести в консоль
     */
}
