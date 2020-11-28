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
    - Teacher[] teacher //всегда длина 3
    - Student[] student //всегда длина 3

    у всех классов переопределен метод toString()
    все поля приватные + геттеры и сеттеры
    создать объект школы с 3 студертам и 3 учителями
    вывести его в консоль
     */

    public static void main(String[] args)
    {
        School school = new School(
                1,
                "fspo",
                new Teacher(
                        "Vasiliy",
                        "Vasylievi4",
                        "pp",
                        15
                ),
                new Student(
                        "vasya",
                        "lopatkin",
                        10
                )
        );

        System.out.println(school);
    }
}

//примеры инициализии массивов в качество вложенных объектов
class Test
{
    private String[] arr;// = new String[2];

    public Test(String[] arr) {
        this.arr = arr;
    }

    public Test() {
        this.arr = new String[2];
    }

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }
}
