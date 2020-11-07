package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.database.entity.UserEntity;
import ru.pa4ok.demoexam.database.manager.UserEntityManager;
import ru.pa4ok.demoexam.util.MysqlDatabase;

import java.security.UnrecoverableEntryException;
import java.sql.SQLException;
import java.util.Scanner;

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
        new Main();
    }

    private final MysqlDatabase database = new MysqlDatabase(
            "116.202.236.174",
            "DemoExam",
            "DemoExam",
            "DemoExam"
    );
    private final UserEntityManager userEntityManager = new UserEntityManager(database);
    private final Scanner scanner = new Scanner(System.in);
    private UserEntity authedUser;


    public Main()
    {
        boolean alive = true;
        while(alive)
        {
            switch (Integer.parseInt(scanner.nextLine()))
            {
                case 1:
                    register();
                    break;
                case 2:
                    auth();
                    break;
                case 3:
                    changeLogin();
                    break;
                case 4:
                    changePass();
                    break;
                case 5:
                    deleteAccount();
                    break;
                case 0:
                    alive = false;
                    break;
                default:
                    System.out.println("Нет такого варианта");
                    break;
            }
        }
    }

    private void printChoice()
    {
        System.out.println("1 - регистрация");
        System.out.println("2 - авторизация");
        System.out.println("3 - смена логина");
        System.out.println("4 - смена пароля");
        System.out.println("5 - удаление аккаунта");
        System.out.println("0 - выход");
    }

    private void register()
    {
        System.out.println("Введеите логин, пароль, возраст, профессию");
        UserEntity userEntity = new UserEntity(
                scanner.nextLine(),
                scanner.nextLine(),
                Integer.parseInt(scanner.nextLine()),
                scanner.nextLine()
        );
        if(!userEntity.validate()) {
            System.out.println("Поля введены неверно");
            return;
        }
        try {
            userEntityManager.add(userEntity);
            this.authedUser = userEntity;
        } catch (SQLException e) {
            System.out.println("Ошибка регистрации");
            e.printStackTrace();
        }
    }

    private void auth()
    {
        if(authedUser != null) {
            System.out.println("Вы уже авторизованы");
            return;
        }

        System.out.println("Введеите логин, пароль");
        try {
            authedUser = userEntityManager.getByAuth(
                    scanner.nextLine(),
                    scanner.nextLine()
            );
        } catch (SQLException e) {
            System.out.println("Ошибка авторизации");
            e.printStackTrace();
        }

        if(authedUser != null) {
            System.out.println("Успешно авторизован пользователь: " + authedUser);
        } else {
            System.out.println("Неверный логин/пароль");
        }
    }

    private void changeLogin()
    {

    }

    private void changePass()
    {

    }

    private void deleteAccount()
    {

    }
}
