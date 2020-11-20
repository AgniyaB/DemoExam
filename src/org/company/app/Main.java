package org.company.app;

import org.company.app.database.entity.UserEntity;
import org.company.app.database.manager.UserEntityManager;
import org.company.app.util.MysqlDatabase;

import java.sql.SQLException;
import java.util.Scanner;

public class Main
{
     /*
    UserEntity
    - int id
    - String login (не более 20 символов)
    - String password (не более 32 символов)
    - int age (>=0)
    - String job (не более 45 символов)

    создать базу и таблицу с пользователями
    написать обработчик для сущности пользователя
    выбор вариантов из консоли

    1 - регистрация
    2 - авторизация
    3 - смена никнейма
    4 - смена пароля
    5 - выход из аккаунта
    6 - удаление аккаунта
    7 - выход из программы

    при смене логина/пароля или удалении акаунта необходимо проверять авторизацию
    при вводе любых полей нужно проверять их на корректность
    */

    private final MysqlDatabase database = new MysqlDatabase(
            "116.202.236.174",
            "DemoExam",
            "DemoExam",
            "DemoExam"
    );
    private final UserEntityManager userEntityManager = new UserEntityManager(database);
    private final Scanner scanner = new Scanner(System.in);

    private Main()
    {
        while(true) {
            System.out.println();
            System.out.printf("Введите логин: ");
            String login = scanner.nextLine();
            System.out.printf("Введите пароль: ");
            String password = scanner.nextLine();

            UserEntity user = null;

            try {
                 user = userEntityManager.getByLoginAndPassword(login, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if(user != null) {
                System.out.println("Успешно авторизован: " + user);
            } else {
                System.out.println("Неверный логин/пароль");
            }
        }
    }

    public static void main(String[] args)
    {
        new Main();
    }
}
