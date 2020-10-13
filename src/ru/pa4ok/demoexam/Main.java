package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        School school = new School("spb", 4, 1, "fspo");

        school.addEntity(new Student("vasya", 15, false, 5));
        school.addEntity(new Teacher("grin4pun", 60, false, "pp", 20));
        school.addEntity(new Human("petya", 15, false));

        System.out.println(school);
        for(int i=0; i<3; i++) {
            school.nextYear();
        }
        System.out.println(school);
    }

    /*
    везде toString()
    в наследуемых классах поля protected
    в остальных private
    + геттеры и сеттеры

    Human
    - String name
    - int age
    - boolean isWoman
    - void nextYear() // age++

    Teacher extends Human
    - String subject
    - int exp //стаж
    - void nextYear() // вызывать родительский метод, потом exp++

    Student extends Human
    - int level
    - void nextYear() // вызывать родительский метод, потом level++

    Building
    - String address
    - int floorCount

    School extends Building
    - int index
    - String title
    - List<Teacher> teachers
    - List<Student> students
    - void addEntity(Human human)
        проверить если human является Teacher
        то его надо добавить в teachers
        если human является Student
        то его надо добавить в students
        если не то и не то, то вывести в консоль
    - void nextYear() //просто одинаковое название, может называться как угодно
        //перебирать всех teachers и students
        //и вызывать у них метод nextYear()
     */
}
