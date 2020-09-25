package ru.pa4ok.demoexam;

public class Main
{
    public static void main(String[] args)
    {
        /*
        все поля в классах приватные
        + геттеры и сеттеры

        School
        - int number
        - String title
        - Teacher[2]
        - Student[4]
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

        /*Teacher teacher = new Teacher("teacher", "матан");
        Student student1 = new Student("Vasya", 5);
        Student student2 = new Student("Petya", 11);

        School school = new School(1, "school");
        school.getTeachers()[0] = teacher;
        school.getStudents()[0] = student1;
        school.getStudents()[1] = student2;*/

        /*Teacher[] teachers = {
                new Teacher("teacher", "матан")
        };

        Student[] students = {
                new Student("Vasya", 5),
                new Student("Petya", 11)
        };
        School school = new School(1, "school", teachers, students);*/

        /*School school = new School(
                1,
                "school",
                new Teacher[] {
                        new Teacher("teacher", "матан")
                },
                new Student[] {
                        new Student("Vasya", 5),
                        new Student("Petya", 11)
                }
        );

        System.out.println(school);*/

        //System.out.println(Math.PI);
        //System.out.println(Math.cos(Math.PI));
    }
}
