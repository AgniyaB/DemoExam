package org.orgname.app;

import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.MysqlDatabase;

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
    3 - смена никнейма с проверкой корректности поля и проверкой авторизации
    4 - смена пароля с проверкой корректности поля и проверкой авторизации
    5 - удалить пользователя с проверкой авторизации
    */

    public static void main(String[] args)
    {
        try {

            MysqlDatabase database = new MysqlDatabase("116.202.236.174", "DemoExam", "DemoExam", "DemoExam");
            UserEntityManager userEntityManager = new UserEntityManager(database);

            /*UserEntity user = new UserEntity("Pa4ok1", "22813371");
            System.out.println(user);
            userEntityManager.add(user);
            System.out.println(user);*/

            /*System.out.println(userEntityManager.getById(2));
            System.out.println(userEntityManager.getById(228));*/

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
