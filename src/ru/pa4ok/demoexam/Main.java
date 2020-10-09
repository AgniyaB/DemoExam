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

        human.work();
        System.out.println();
        student.work();


        //System.out.println(h);
        //System.out.println(student);
        //System.out.println(teacher);
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

    Teacher extends Human
    - String subject

    Student extends Human
    - int level

    Building
    - String address
    - int florCount

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

     */

    /*private static void printHumanAge(Human human)
    {
        System.out.println(human.getAge());
    }*/
}
