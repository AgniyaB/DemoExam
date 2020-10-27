package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.type.GenderEnum;
import ru.pa4ok.demoexam.type.SchoolTypeEnum;

public class Main
{
    /*
    крайний коммит с работой со школой
    https://github.com/Pa4ok/DemoExam/tree/36f5788f1d226e6eab8c259649b89c31974b3eae/src/ru/pa4ok/demoexam

    enum GenderEnum
    - MALE
    - FEMALE

    Human
    - String name
    - int age
    - GenderEnum gender

    Student extends Human
    - int level

    Teacher extends Human
    - String subject

    BuildingTypeEnum
    - SOCIAL
    - HOME
    - GOVERNMENT

    Building
    - String address
    - int floorCount
    - BuildingTypeEnum buildingType

    SchoolTypeEnum
    - PRIMARY
    - MEDIUM
    - HIGH

    School extends Building
    - int index
    - String name
    - SchoolTypeEnum schoolType
    - List<Teacher> teachers
    - List<Student> students
    - void addEntity(Human)
        метод принимает либой объект Human
        может быть как Student так и Teacher
        если это Teacher - кинуть к List<Teacher> teachers
        если это Student - кинуть к List<Student> students
     */

    public static void main(String[] args)
    {
        School school = new School(
                "spb",
                4,
                1,
                "super school",
                SchoolTypeEnum.HIGH
        );

        System.out.println(school);

        school.addEntity(new Teacher("grin4pun", 60, GenderEnum.MALE, "pp", 20));
        school.addEntity(new Student("vasya", 15, GenderEnum.MALE, 9));

        System.out.println(school);
    }
}
