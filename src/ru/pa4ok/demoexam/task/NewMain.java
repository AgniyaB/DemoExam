package ru.pa4ok.demoexam.task;

public class NewMain
{
    public static void main(String[] args)
    {
        /*School school = new School("spb", 4, 1, "fspo");
        System.out.println(school);
        school.addEntity(new Teacher("grin4pun", 49, false, "pp"));
        school.addEntity(new Student("Veronika",15,  true, 10));
        System.out.println(school);
        school.addEntity(new Human("wojdwq", 124, false));*/

        Student student = new Student("Vasya", 15, false, 5);
        System.out.println(student);
        student.updateYear();
        System.out.println(student);
    }

    /*
    //все поля protected + геттеры и сеттеры
    Human
    - String name
    - int age
    - boolean isWoman
    - void updateYear() //увеличивает возраст на 1

    Teacher extends Human
    - String subject

    Student extends Human
    - int level
    - void updateYear()
    //вызывает родителький метод,
    //после чего увиличивает класс на 1

    Building
    - String adress
    - int floorCount

    School extends Building
    - int index
    - String name
    - List<Teacher> teachers
    - List<Student> students
    - addEntity(Human human)
        //если human является Teacher добавить к teachers
        //если human является Student добавить к students
        //если не то, не то, тогда вывести в консоль
     */
}
