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
    private UserEntity authedUser;

    private Main() throws SQLException
    {
        while (true)
        {
            printChoice();
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
                    authedUser = null;
                    break;
                case 6:
                    deleteUser();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Нет такого выбора");
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
        System.out.println("5 - выход из аккаунта");
        System.out.println("6 - удаление аккаунта");
        System.out.println("7 - выход из программы");
    }

    private void register() throws SQLException
    {
        String login = scanner.nextLine();
        if(UserEntity.isLoginIncorrect(login)) {
            System.out.println("Некоректный логин");
            return;
        }

        String password = scanner.nextLine();
        if(UserEntity.isPasswordIncorrect(password)) {
            System.out.println("Некоректный пароль");
            return;
        }

        String ageString = scanner.nextLine();
        if(UserEntity.isAgeIncorrect(ageString)) {
            System.out.println("Некоректный возраст");
            return;
        }

        String job = scanner.nextLine();
        if(UserEntity.isJobIncorrect(job)) {
            System.out.println("Некоректная профессия");
            return;
        }

        UserEntity user = new UserEntity(login, password, Integer.parseInt(ageString), job);
        userEntityManager.add(user);
        authedUser = user;
        System.out.println("Успешно зарегистрирован " + user);
    }

    private void auth() throws SQLException
    {
        String login = scanner.nextLine();
        String password = scanner.nextLine();

        UserEntity user = userEntityManager.getByLoginAndPassword(login, password);
        if(user != null) {
            authedUser = user;
            System.out.println("Успешно авторизован " + user);
        } else {
            System.out.println("Неверный логин/пароль");
        }
    }

    private void changeLogin() throws SQLException
    {
        if(authedUser == null) {
            System.out.println("Вы не авторизованы");
            return;
        }

        String login = scanner.nextLine();
        if(UserEntity.isLoginIncorrect(login)) {
            System.out.println("Некоректный логин");
            return;
        }

        authedUser.setLogin(login);
        userEntityManager.update(authedUser);
        System.out.println("Логин изменен " + authedUser);
    }

    private void changePass() throws SQLException {
        if (authedUser == null) {
            System.out.println("Вы не авторизованы");
            return;
        }

        String password = scanner.nextLine();
        if (UserEntity.isPasswordIncorrect(password)) {
            System.out.println("Некоректный пароль");
            return;
        }

        authedUser.setPassword(password);
        userEntityManager.update(authedUser);
        System.out.println("Пароль изменен " + authedUser);
    }


    private void deleteUser() throws SQLException
    {
        if(authedUser == null) {
            System.out.println("Вы не авторизованы");
            return;
        }

        userEntityManager.deleteById(authedUser.getId());
        authedUser = null;
    }

    public static void main(String[] args) throws SQLException
    {
        new Main();
    }
}
