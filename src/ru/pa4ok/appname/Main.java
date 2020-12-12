package ru.pa4ok.appname;

import sun.security.krb5.SCDynamicStoreConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    /*
    Human
    - String surname
    - String firstname
    - boolean isWoman
    - int age
    - public void nextYear() //age++

    Student extends Human
    - int level //класс
    - public void nextYear() //вызывать родительскую реализации и level++

    Teacher extends Human
    - int exp //стаж
    - public void nextYear() //вызывать родительскую реализации и exp++

    School
    - int number
    - String title
    - List<Teacher> teachers
    - List<Student> students
    - void addEntity(Human human)
        функция принимает любого Hunan
        если приходит Student - добавить в список студентов
        если приходит Teacher - добавить в список преподавателей
        если и не то, и не то - вывести в консоль "Not a school entity"
    - void nextYearAll()
        перебирать всех студетов и преподавателей
        и вызывать у них метод nextYear()


    у всех классов переопределен метод toString()
    у классов которые наследуются поля protected
    у отсальных классов все поля private
    везде есть геттеры и сеттеры
    создать объект школы с инициализированными пустимы списками
    добавить пару студентов и преподавателей через метод addEntit
    вывести объект школы в консоль
    вызвать метод nextYearAll()
    вывести объект школы в консоль
     */

    public static void main(String[] args)
    {
        Human human = new Human("vasya", "fewwefew", false, 40);
        Student student = new Student("petya", "okewfife", false, 15, 7);
        Teacher teacher = new Teacher("oshurok", "okefwfeewf", false, 30, "pp", 10);

        /*School school = new School(1, "первая");
        System.out.println(school);
        System.out.println();
        school.addEntity(human);
        school.addEntity(student);
        school.addEntity(teacher);
        System.out.println();
        System.out.println(school);*/

        //human.work();
        student.work();
        //teacher.work();
    }
}
