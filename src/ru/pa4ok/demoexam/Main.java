package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.database.entity.UserEntity;
import ru.pa4ok.demoexam.database.manager.UserEntityManager;
import ru.pa4ok.demoexam.util.MysqlDatabase;

import java.sql.SQLException;
import java.util.List;

public class Main
{
    /*
    UserEntity
    - int id
    - String login
    - String password
    - int age
    - String job

    выбор вариантов из консоли
    1 - регистрация с проверкой на никнейм
    2 - авторизация
    3 - смена никнейма с проверкой
    4 - смена пароля
    5 - удалить пользователя

    добавьте проверки на длину логина пароля
    проверку возраста на положительное число
     */

    public static void main(String[] args)
    {
        MysqlDatabase database = new MysqlDatabase("116.202.236.174", 3306, "DemoExam", "DemoExam", "DemoExam");
        UserEntityManager userEntityManager = new UserEntityManager(database);

        try {

            //System.out.println(userEntityManager.addUser(new UserEntity("Pa4ok", "12345")));
            //System.out.println(userEntityManager.getUserById(7));

            //List<UserEntity> allUsers = userEntityManager.getAllUsers();
            //System.out.println(allUsers);

            /*UserEntity user = userEntityManager.getUserById(3);
            user.setLogin("new login");
            user.setPassword("minecraft1");
            System.out.println(userEntityManager.update(user));*/

            userEntityManager.deleteById(4);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
