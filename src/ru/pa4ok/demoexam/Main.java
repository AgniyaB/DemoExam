package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Human human = new Human("vasya", 15, false);
        Human student = new Student("petya", 16, false, 5);
        Human teacher = new Teacher("grin4pun", 60, false, "pp");

        //printHumanAge(student);
        //printHumanAge(teacher);

        /*List<Teacher> teacherList = new ArrayList<>();
        if(student instanceof Teacher) {
            teacherList.add((Teacher)student);
        }
        if(teacher instanceof Teacher) {
            teacherList.add((Teacher)teacher);
        }
        System.out.println(teacherList);*/

        //human.work();
        //System.out.println();
        //student.work();


        //System.out.println(h);
        //System.out.println(student);
        //System.out.println(teacher);

        School school = new School("spb", 4, 1, "fspo");
        System.out.println(school);
        school.addEntity(teacher);
        school.addEntity(student);
        school.addEntity(human);
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

    /*private static void printHumanAge(Human human)
    {
        System.out.println(human.getAge());
    }*/
}
