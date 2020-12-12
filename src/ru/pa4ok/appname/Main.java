package ru.pa4ok.appname;

public class Main
{
    /*
    Human
    - String surname
    - String firstname
    - boolean isWoman
    - int age

    abstract WorkerHuman extends Human
    - String workTitle
    - int salary
    - public abstract void work()

    //несколько классов различных профессий
    Miner extends WorkerHuman
    - public void work() //реализованная абстрактная функция
    //

    LaborExchange (биржа труда)
    - String address
    - List<Human> needWorksPeople
    - public void needWork(Human human)
        проверить если Human реализует класс WorkerHuman
        то вывести, что у него уже есть работа
        если у Human нет работы - добавить в needWorksPeople

     Создать объект LaborExchange
     добавить туда несколько разных работающих и обычных людей
     вывести в консоль
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
        school.nextYearAll();
        school.nextYearAll();
        System.out.println(school);
    }
}
