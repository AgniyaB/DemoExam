package ru.pa4ok.appname;

import ru.pa4ok.appname.database.entity.FilmEntity;
import ru.pa4ok.appname.database.entity.UserEntity;
import ru.pa4ok.appname.database.manager.FilmEntityManager;
import ru.pa4ok.appname.database.manager.UserEntityManager;
import ru.pa4ok.appname.util.MysqlDatabase;

import java.sql.SQLException;

public class Main
{
    public static void main(String[] args)
    {
        MysqlDatabase database = new MysqlDatabase("116.202.236.174", "DemoExam", "DemoExam", "DemoExam");
        UserEntityManager userEntityManager = new UserEntityManager(database);
        FilmEntityManager filmEntityManager = new FilmEntityManager(database);

        /*UserEntity user = new UserEntity("Pa4ok-261220-2", "Pa4ok-261220", 15, "hacker");
        try {
            System.out.println(user);
            userEntityManager.add(user);
            System.out.println(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

        /*try {
            System.out.println(userEntityManager.getAll());
            UserEntity user = userEntityManager.getById(2);
            user.setJob("new job 30000");
            userEntityManager.update(user);
            System.out.println(userEntityManager.getAll());
            userEntityManager.delete(user);
            System.out.println(userEntityManager.getAll());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

        try {

            //filmEntityManager.add(new FilmEntity("mstiteli-2", "qwpjeqwpif", 1000000000, 3.5));
            //System.out.println(filmEntityManager.getAll());
            FilmEntity first = filmEntityManager.getById(1);
            first.setAuthor("kolya");
            filmEntityManager.update(first);
            System.out.println(filmEntityManager.getAll());
            filmEntityManager.deleteById(2);
            System.out.println(filmEntityManager.getAll());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
