package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.database.entity.UserEntity;
import ru.pa4ok.demoexam.database.manager.UserEntityManager;
import ru.pa4ok.demoexam.util.MysqlDatabase;

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

            //userEntityManager.add(new UserEntity("pa4ok", "2281337"));
            //System.out.println(userEntityManager.getById(15));
            //System.out.println(userEntityManager.getAll());
            //userEntityManager.update(new UserEntity(12, "pa4ok-new", "pass-new"));
            System.out.println(userEntityManager.deleteById(11));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
