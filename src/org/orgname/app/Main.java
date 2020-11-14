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
    3 - смена никнейма с проверкой корректности поля
    4 - смена пароля с проверкой корректности поля
    5 - удалить пользователя
    */

    public static void main(String[] args) throws SQLException
    {
        new Main();
        System.out.println("Программа завершила свою работу.");
    }

    private final MysqlDatabase database = new MysqlDatabase(
            "116.202.236.174",
            "DemoExam",
            "DemoExam",
            "DemoExam"
    );
    private final UserEntityManager userManager = new UserEntityManager(database);
    private Scanner scanner = new Scanner(System.in);
    private UserEntity authedUser = null;

    public Main() throws SQLException
    {
        while(true)
        {
            printChoice();
            String choiceString = scanner.nextLine();
            if(choiceString == null || choiceString.equals("")) {
                System.out.println("Ответ не введен");
                continue;
            }
            int i;
            try {
                i = Integer.parseInt(choiceString);
            } catch (NumberFormatException e) {
                System.out.println("Неправильный формат ввода");
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
                    changePassword();
                    break;
                case 5:
                    logout();
                    break;
                case 6:
                    deleteUser();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Нет такого варианта");
                    break;
            }
        }
    }

    private void printChoice()
    {
        System.out.println("Выберите действие");
        System.out.println("1 - регистрация");
        System.out.println("2 - авторизация");
        System.out.println("3 - смена логина");
        System.out.println("4 - смена пароля");
        System.out.println("5 - выход из аккаунта");
        System.out.println("6 - удаление аккаунта");
        System.out.println("7 - закрыть");
    }

    private void register() throws SQLException
    {
        System.out.printf("Введите логин: ");
        String login = scanner.nextLine();
        if(UserEntity.isLoginInCorrect(login)) {
            System.out.println("Некоректный логин");
            return;
        }
        if(userManager.getByLogin(login) != null) {
            System.out.println("Пользователь с таким логином уже существует");
            return;
        }

        System.out.printf("Введите пароль: ");
        String pass = scanner.nextLine();
        if(UserEntity.isPasswordInCorrect(pass)) {
            System.out.println("Некоректный пароль");
            return;
        }

        System.out.printf("Введите возраст: ");
        String ageString = scanner.nextLine();
        if(UserEntity.isAgeInCorrect(ageString)) {
            System.out.println("Некоректный возраст");
            return;
        }
        int age = Integer.parseInt(ageString);

        System.out.printf("Введите профессию: ");
        String job = scanner.nextLine();
        if(UserEntity.isJobInCorrect(job)) {
            System.out.println("Некоректная профессия");
            return;
        }

        UserEntity user = new UserEntity(login, pass, age, job);
        userManager.add(user);
        authedUser = user;
        System.out.println("Регистрация успешно выполнена");
    }

    private void auth() throws SQLException
    {
        if(authedUser != null) {
            System.out.println("Вы уже авторизованы");
            return;
        }

        System.out.printf("Введите логин: ");
        String login = scanner.nextLine();
        System.out.printf("Введите пароль: ");
        String pass = scanner.nextLine();

        UserEntity user = userManager.getByLoginAndPass(login, pass);
        if(user != null) {
            authedUser = user;
            System.out.println("Вы успешно авторизованы: " + user);
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

        System.out.printf("Введите новый логин: ");
        String login = scanner.nextLine();
        if(UserEntity.isLoginInCorrect(login)) {
            System.out.println("Некоректный логин");
            return;
        }

        authedUser.setLogin(login);
        userManager.update(authedUser);
        System.out.println("Логин успешно сменен: " + authedUser);
    }

    private void changePassword() throws SQLException
    {
        if(authedUser == null) {
            System.out.println("Вы не авторизованы");
            return;
        }

        System.out.printf("Введите новый пароль: ");
        String pass = scanner.nextLine();
        if(UserEntity.isPasswordInCorrect(pass)) {
            System.out.println("Некоректный пароль");
            return;
        }

        authedUser.setPassword(pass);
        userManager.update(authedUser);
        System.out.println("Пароль успешно сменен: " + authedUser);
    }

    private void logout()
    {
        if(authedUser == null) {
            System.out.println("Вы не авторизованы");
            return;
        }

        authedUser = null;
        System.out.println("Вы успешно вышли");
    }

    private void deleteUser() throws SQLException
    {
        if(authedUser == null) {
            System.out.println("Вы не авторизованы");
            return;
        }

        userManager.delete(authedUser);
        authedUser = null;
        System.out.println("Аккаунт успешно удален");
    }
}
