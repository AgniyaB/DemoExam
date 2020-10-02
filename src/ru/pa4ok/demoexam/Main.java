package ru.pa4ok.demoexam;

public class Main
{
    public static void main(String[] args)
    {
        /*Student student = new Student("Vasya", 15, false, 1, 5);
        System.out.println(student);

        student.test();*/

        Human h1 = new Man("Petya", 40);
        Human h2 = new Woman("Lena", 35);

        //System.out.println(man);
        //System.out.println(woman);

        //проверка на принадлежность класса через наследование
        System.out.println(h1 instanceof Woman);
        System.out.println(h2 instanceof Woman);
    }

    public static void doWork(Human human)
    {
        if(human instanceof Man) {
            //дествие 1
        } else {
            //действие 2
        }
    }

    /*
    Human
    - String name
    - int age
    - boolean isWoman

    Man extends Human
    - доп полей нет
    - всегда передает isWoman = false

    Woman extends Human
    - доп полей нет
    - всегда передает isWoman = true
     */
}
