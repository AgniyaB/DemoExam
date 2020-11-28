package ru.pa4ok.appname;

import java.util.Arrays;

public class Main
{
    /*
    Student
    - String surname
    - String firstname
    - int level //класс

    Teacher
    - String surname
    - String firstname
    - int exp //стаж

    School
    - int number
    - String title
    - Teacher teacher
    - Student student
    
    у всех классов переопределен метод toString()
    все поля приватные + геттеры и сеттеры
    создать объект школы с студертом и учителем
    вывести его в консоль
     */

    public static void main(String[] args)
    {
        /*Person[] arr = new Person[10];
        System.out.println(Arrays.toString(arr));
        for(int i=0; i<arr.length; i++) {
            arr[i] = new Person(1, "first-" + i, "surname-" + i, 15 + i);
        }
        System.out.println(Arrays.toString(arr));*/

        /*Passport passport = new Passport(
                4014,
                077754,
                "spb peso4naya 14"
        );*/

        Person p = new Person(
                1,
                "Vasya",
                "Shurik",
                15,
                new Passport(
                        4014,
                        077754,
                        "spb peso4naya 14"
                )
        );

        System.out.println(p.getPassport().getAddress());
    }
}
