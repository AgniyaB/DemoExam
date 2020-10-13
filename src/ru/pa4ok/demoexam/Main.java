package ru.pa4ok.demoexam;

public class Main
{
    /*
    поля наследуемых классов protected
    остальные поля private + геттеры и сеттеры
    + везде toString()

    Human
    - String name
    - int age
    - boolean isWoman

    Student extends Human
    - int level

    Teacher extends Human
    - String subject
    - int exp

    Building
    - String address
    - int floorCount

    School extends Building
    - int index
    - String title
    - List<Teacher> teachers
    - List<Student> students
    - void addEntity(Human human)
        проверить, если human это Student
        то добавить его в students
        если human это Teacher
        то добавить его в teachers
        если не то и не то - вывести в консоль

     */

    public static void main(String[] args)
    {
        Human human = new Human("Vasya", 15, false);

        //так можно
        Student s1 = new Student("Petya", 16, false, 5);
        Human s2 = new Student("Petya", 16, false, 5);
        Human s3 = new Teacher("grin4pun", 60, false, "pp", 20);
        //

        //printNameAndAge(s2);
        //printNameAndAge(s3);
        //System.out.println(human);

        //является ли класс объекта s2 Teacher или наследует его?
        //sSystem.out.println(s2 instanceof Teacher);
        //System.out.println(s3 instanceof Teacher);

        //сначала проверяем на принадлежность и только потом делаем приведение типов
        /*if(s2 instanceof Student) {
            Student student = (Student)s2;
            System.out.println(student);
        }*/

        s1.test();
    }

    private static void printNameAndAge(Human human)
    {
        System.out.println(human.getName() + " " + human.getAge());
    }
}
