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
        while(true)
        {
            printChoice();
            String choice = scanner.nextLine();
            if(choice == null || choice.equals("")) {
                System.out.println("Введите выбор");
            }

            int i;
            try {
               i = Integer.parseInt(choice);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не цифру");
                continue;
            }

            switch (i)
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
                    return;
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
        if(authedUser == null) {
            System.out.println("Вы не авторизованы");
            return;
        }

        String oldLogin = authedUser.getLogin();
        authedUser.setLogin(scanner.nextLine());
        if(!authedUser.validate()) {
            authedUser.setLogin(oldLogin);
            System.out.println("Логин введен некоректно");
            return;
        }

        try {
            userEntityManager.update(authedUser);
            System.out.println("Логин успешно изменен: " + authedUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void changePass()
    {
        if(authedUser == null) {
            System.out.println("Вы не авторизованы");
            return;
        }

        String oldPass = authedUser.getPassword();
        authedUser.setPassword(scanner.nextLine());
        if(!authedUser.validate()) {
            authedUser.setPassword(oldPass);
            System.out.println("Пароль введен некоректно");
            return;
        }

        try {
            userEntityManager.update(authedUser);
            System.out.println("Пароль успешно изменен: " + authedUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteAccount()
    {
        if(authedUser == null) {
            System.out.println("Вы не авторизованы");
            return;
        }

        try {
            userEntityManager.delete(authedUser);
            System.out.println("Пользователь успешно удален");
            authedUser = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
