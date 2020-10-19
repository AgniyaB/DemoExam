package ru.pa4ok.demoexam;

public class Main
{
    public static void main(String[] args)
    {
        School school = new School("adreesssss", 4, 1, "fspo", SchoolTypeEnum.HIGH);
        System.out.println(school);
        school.addEntity(new Teacher("grin4pun",50, GenderEnum.MALE, "pp"));
        school.addEntity(new Student("Vasya", 15, GenderEnum.MALE, 5));
        System.out.println(school);
    }
}
