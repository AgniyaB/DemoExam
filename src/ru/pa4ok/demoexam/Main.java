package ru.pa4ok.demoexam;

public class Main
{
    public static void main(String[] args)
    {
        School school = new School(
                "spb",
                4,
                BuildingType.SOCIAL,
                1,
                "spo"
        );

        school.getTeachers().add(new Teacher("grin4pun", 60, Gender.MALE, "pp", 20));
        school.getTeachers().add(new Teacher("oshurok", 35, Gender.MALE, "up", 5));
        school.getStudents().add(new Student("vasya", 15, Gender.MALE, 5));
        school.getStudents().add(new Student("ira", 16, Gender.FEMALE, 6));
        school.getStudents().add(new Student("petya", 17, Gender.MALE, 7));

        System.out.println(school);
    }

    /*
    все поля в наследуемых классах protected
    в остальных private + геттеры и сеттеры
    + toString()

    abstract Human
    - String name
    - int age
    - Gender gender

    enum Gender
    - MALE
    - FEMALE

    Student extends Human
    - int level //класс

    Teacher extends Human
    - String subject
    - int exp //стаж

    abstract Building
    - String address
    - int floorCount
    - BuildingType type

    enum BuildingType
    - SOCIAL
    - HOUSE
    - GOVERNMENT

    School extends Building
    - int index
    - String title
    - List<Teacher> teachers
    - List<Student> students
     */
}
