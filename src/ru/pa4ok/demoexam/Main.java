package ru.pa4ok.demoexam;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Student s = new Student("Vasya", "Grin4pun", 9);
        System.out.println(s);
        //student.getStrings()[1] = "dssdads";

        System.out.println(Student.CITY);
        Student.testStatic();

        //неправильный вариант
        //System.out.println(s.CITY);

        System.out.println(Math.PI);
        System.out.println(Math.cos(Math.PI));

        //test() - не будет работать\

        testStatic();

        Main main = new Main();
        main.test();
    }

    private void test(){

    }

    private static void testStatic() {

    }
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
}

