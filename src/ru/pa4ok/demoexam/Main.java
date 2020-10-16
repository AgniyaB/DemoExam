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
    - void nextYear()

    Student extends Human
    - int level
    - void nextYear() //родительский, level++

    Teacher extends Human
    - String subject
    - int exp
    - void nextYear() //родительский, exp++

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
    - void nextYear()
        перебирает всех учителей и студентов
        вывывает у низ nextYear()

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

        School school = new School(
                "spb",
                4,
                1,
                "fspo"
        );

        System.out.println(school);
        school.addEntity(new Teacher("grin4pun", 60, false, "pp", 20));
        school.addEntity(new Student("Petya", 16, false, 5));
        school.addEntity(new Student("Vasya", 16, false, 5));
        school.addEntity(new Human("54345", 23, true));
        System.out.println(school);
        for(int i=0; i<3; i++) {
            school.nextYear();
        }
        System.out.println(school);
    }

    private static void printNameAndAge(Human human)
    {
        System.out.println(human.getName() + " " + human.getAge());
    }
}
