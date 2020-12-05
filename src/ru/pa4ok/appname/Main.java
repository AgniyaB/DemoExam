package ru.pa4ok.appname;

import sun.security.krb5.SCDynamicStoreConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    - List<Teacher> teachers
    - List<Student> students
    - void addEntity(Human human)
        функция принимает любого Hunan
        если приходит Student - добавить в список студентов
        если приходит Teacher - добавить в список преподавателей
        если и не то, и не то - вывести в консоль "Not a school entity"


    у всех классов переопределен метод toString()
    у классов которые наследуются поля protected
    у отсальных классов все поля private
    везде есть геттеры и сеттеры
    создать объект школы с инициализированными пустимы списками
    добавить пару студентов и преподавателей через метод addEntity
    вывести объект школы в консоль
     */

    public static void main(String[] args)
    {
        Human human = new Human("vasya", "fewwefew", false, 40);
        Student student = new Student("petya", "okewfife", false, 15, 7);
        Teacher teacher = new Teacher("oshurok", "okefwfeewf", false, 30, "pp", 10);

        School school = new School(1, "первая");
        System.out.println(school);
        System.out.println();
        school.addEntity(human);
        school.addEntity(student);
        school.addEntity(teacher);
        System.out.println();
        System.out.println(school);
    }
}
