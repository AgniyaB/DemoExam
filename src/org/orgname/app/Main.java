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
    - String login (не более 20 символов)
    - String password (не более 32 символов)
    - int age (>0)
    - String job (не более 45 символов)

    создать базу и таблицу с пользователями
    написать обработчик для сущности пользователя

    выбор вариантов из консоли
    1 - регистрация с проверками корректности полей
    2 - авторизация
    3 - смена никнейма с проверкой корректности поля
    4 - смена пароля с проверкой корректности поля
    5 - удалить пользователя
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

            //System.out.println(userEntityManager.getById(20));
            //System.out.println(userEntityManager.getById(228));

            //System.out.println(userEntityManager.getAll());

            /*UserEntity user20 = userEntityManager.getById(20);
            user20.setLogin("Pa4ok-new");
            user20.setPassword("1234567890");
            System.out.println(userEntityManager.update(user20));*/

            userEntityManager.deleteById(21);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
