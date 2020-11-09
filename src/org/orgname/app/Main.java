package org.orgname.app;

import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.MysqlDatabase;

import java.sql.SQLException;

public class Main
{
    /*
     UserEntity
    - int id
    - String login
    - String password
    - int age
    - String job

    создать базу и обработчик для сущности
    считывать с консоли логин и пароль
    добавить пару пользователь
    если есть совпадение по обоим
    получать и выводить сущность в консоль
    если нет - вывести "неверный логин/пароль"
     */

    public static void main(String[] args)
    {
        MysqlDatabase database = new MysqlDatabase("116.202.236.174", "DemoExam", "DemoExam", "DemoExam");
        UserEntityManager userEntityManager = new UserEntityManager(database);

        try {

            /*UserEntity user = new UserEntity("Pa4ok", "2281337");
            System.out.println(user);
            userEntityManager.add(user);
            System.out.println(user);*/

            //System.out.println(userEntityManager.getById(18));
            //System.out.println(userEntityManager.getById(288));

            //System.out.println(userEntityManager.getAll());

            /*UserEntity user = userEntityManager.getById(18);
            user.setLogin("new Pa4ok");
            user.setPass("1234567890");
            userEntityManager.update(user);*/

            userEntityManager.deleteById(17);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
