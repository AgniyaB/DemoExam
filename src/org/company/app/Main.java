package org.company.app;

import org.company.app.database.entity.UserEntity;
import org.company.app.database.manager.UserEntityManager;
import org.company.app.util.MysqlDatabase;

public class Main
{
    /*
    UserEntity
    - int id
    - String login
    - String password
    - int age
    - String job

    сделать сущность и обработчик для нее
    создать таблицу и заполнить несколькими сущностями

    пользователь вводит в консоль логин и пароль
    если есть совпадение вывести ему пользователя
    если нет - "неверный логин/пароль"
     */

    public static void main(String[] args)
    {
        try {
            MysqlDatabase database = new MysqlDatabase("116.202.236.174", "DemoExam", "DemoExam", "DemoExam");
            UserEntityManager userEntityManager = new UserEntityManager(database);


            /*UserEntity user = new UserEntity("Pa4ok", "2281337");
            System.out.println(user);
            userEntityManager.add(user);
            System.out.println(user);*/

            //System.out.println(userEntityManager.getById(3));
            //System.out.println(userEntityManager.getById(228));

            //System.out.println(userEntityManager.getAll());

            /*UserEntity user2 = userEntityManager.getById(2);
            user2.setLogin("new Pa4ok");
            user2.setPassword("1234567890");
            userEntityManager.update(user2);*/

            userEntityManager.deleteById(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
