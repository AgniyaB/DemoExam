package ru.pa4ok.appname.intrf;

import ru.pa4ok.appname.Human;

public class Postman extends Human implements IWorker
{
    public Postman(String firstname, String surname, boolean isWoman, int age) {
        super(firstname, surname, isWoman, age);
    }

    @Override
    public String getWorkInfo() {
        return "разносит почту";
    }

    @Override
    public void work() {
        System.out.println("...несет письмо...");
    }

    @Override
    public String toString() {
        return "Postman{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", isWoman=" + isWoman +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args)
    {
        Postman postman = new Postman("wqp[ojfmwwq", "lkwqiwqdd", false, 44);
        /*System.out.println(postman);
        System.out.println(postman instanceof Human);
        System.out.println(postman instanceof IWorker);*/
        test(postman);
    }

    //запустить метод work если класс реализует интрефес
    private static void test(Human human)
    {
        if(human instanceof IWorker) {
            //IWorker iWorker = (IWorker)human;
            //iWorker.work();
            ((IWorker)human).work();
        }
    }
}
