package ru.pa4ok.appname;

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
        System.out.println(human);

        Student student = new Student("petya", "okewfife", false, 15, 7);
        System.out.println(student);

        Teacher teacher = new Teacher("oshurok", "okefwfeewf", false, 30, "pp", 10);
        System.out.println(teacher);

        System.out.println();

        test(human);
        test(student);
        test(teacher);
    }

    //если студент вывести 1, если преподаватель вывести 2
    private static void test(Human human)
    {
        if(human instanceof Student) { //проверка на приналежность класса к другому классу (либо им является, либо наследует его)
            System.out.println("это студент " + human);
            Student s = (Student)human; //приведение типов !делать только после проверки
            System.out.println("Он учится в " + s.getLevel() + " классе");
        } else if(human instanceof Teacher) {
            System.out.println("это преподаватель " + human);
            Teacher t = (Teacher)human;
            System.out.println("У него стаж " + t.getExp() + " лет");
        } else {
            System.out.println("Он не связан со школой " + human);
        }
    }
}
