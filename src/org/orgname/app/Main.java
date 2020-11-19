package org.orgname.app;

import org.orgname.app.database.entity.UserEntity;
import org.orgname.app.database.manager.UserEntityManager;
import org.orgname.app.util.MysqlDatabase;

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
    3 - смена никнейма с проверкой корректности поля и проверкой авторизации
    4 - смена пароля с проверкой корректности поля и проверкой авторизации
    5 - удалить пользователя с проверкой авторизации
    */

    public static void main(String[] args) throws Exception
    {
        new Main();
    }

    private final MysqlDatabase database = new MysqlDatabase("116.202.236.174", "DemoExam", "DemoExam", "DemoExam");
    private final UserEntityManager userEntityManager = new UserEntityManager(database);
    private final Scanner scanner = new Scanner(System.in);
    private UserEntity authedUser;

    public Main() throws SQLException
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
                    changePassword();
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

    private void register() throws SQLException {
        String login = scanner.nextLine();
        if(UserEntity.isLoginIncorrect(login)) {
            System.out.println("Неверный логин");
            return;
        }

        String password = scanner.nextLine();
        if(UserEntity.isPasswordIncorrect(password)) {
            System.out.println("Неверный пароль");
            return;
        }

        String ageString = scanner.nextLine();
        if(UserEntity.isAgeIncorrect(ageString)) {
            System.out.println("Неверный возраст");
            return;
        }

        String job = scanner.nextLine();
        if(UserEntity.isJobIncorrect(job)) {
            System.out.println("Неверная работа");
            return;
        }

        UserEntity user = new UserEntity(login, password, Integer.parseInt(ageString), job);
        userEntityManager.add(user);
        authedUser = user;
        System.out.println("Пользователь зарегистрирован: " + user);
    }

    private void auth() throws SQLException {
        String login = scanner.nextLine();
        String password = scanner.nextLine();

        UserEntity user = userEntityManager.getByLoginAndPassword(login, password);
        if(user == null) {
            System.out.println("Неверный логин/пароль");
            return;
        }

        authedUser = user;
        System.out.println("Успешно авторизован: " + user);
    }

    private void changeLogin() throws SQLException {
        if(authedUser == null) {
            System.out.println("Вы не авторизованы");
            return;
        }

        String login = scanner.nextLine();
        if(UserEntity.isLoginIncorrect(login)) {
            System.out.println("Неверный логин");
            return;
        }

        authedUser.setLogin(login);
        userEntityManager.update(authedUser);
        System.out.println("Логин сменен:" + authedUser);
    }

    private void changePassword() throws SQLException {
        if(authedUser == null) {
            System.out.println("Вы не авторизованы");
            return;
        }

        String password = scanner.nextLine();
        if(UserEntity.isPasswordIncorrect(password)) {
            System.out.println("Неверный пароль");
            return;
        }

        authedUser.setPassword(password);
        userEntityManager.update(authedUser);
        System.out.println("Пароль сменен:" + authedUser);
    }

    private void deleteUser() throws SQLException {
        if(authedUser == null) {
            System.out.println("Вы не авторизованы");
            return;
        }

        userEntityManager.delete(authedUser);
        System.out.println("Акаунт удален");
    }
}
