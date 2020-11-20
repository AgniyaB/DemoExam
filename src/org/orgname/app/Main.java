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
    - String login (от 3 до 20 символов)
    - String password (от 3 до 32 символов)
    - int age (>0)
    - String job (до 50 символов)

    выбор вариантов из консоли
    1 - регистрация с проверкой на никнейм (существующий)
    2 - авторизация
    3 - смена никнейма с проверкой корректности + авторизации
    4 - смена пароля с проверкой корректности + авторизации
    5 - выход из аккаунта
    6 - удалить пользователя с проверкой авторизации
    7 - выход из программы
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
        while(true) {
            printChoice();
            String choiceString = scanner.nextLine();
            if (choiceString == null || choiceString.equals("")) {
                System.out.println("Вы не ввели выбор");
                continue;
            }
            int choiceInt;
            try {
                choiceInt = Integer.parseInt(choiceString);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число");
                continue;
            }

            switch (choiceInt) {
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
        System.out.println("Выберите действие");
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
        String password = scanner.nextLine();
        String ageString = scanner.nextLine();
        String job = scanner.nextLine();

        if(UserEntity.isLoginIncorrect(login)
                || UserEntity.isPasswordIncorrect(password)
                || UserEntity.isAgeIncorrect(ageString)
                || UserEntity.isJobIncorrect(job))
        {
            System.out.println("Данные ведены неверно");
            return;
        }

        UserEntity user = new UserEntity(
                login,
                password,
                Integer.parseInt(ageString),
                job
        );
        userEntityManager.add(user);
        authedUser = user;
    }

    private void auth() throws SQLException
    {
        String login = scanner.nextLine();
        String password = scanner.nextLine();

        UserEntity user = userEntityManager.getByLoginAndPassword(login, password);
        if(user == null) {
            System.out.println("Нет такого пользователя");
        } else {
            System.out.println("Вход совершен:" + user);
            authedUser = user;
        }
    }

    private void changePassword() throws SQLException
    {
        if(authedUser == null) {
            System.out.println("Вы не авторизованы");
            return;
        }

        String password = scanner.nextLine();
        if(UserEntity.isPasswordIncorrect(password)) {
            System.out.println("Некоректный пароль");
            return;
        }

        authedUser.setPass(password);
        userEntityManager.update(authedUser);
        System.out.println("Пароль успешно обновлен " + authedUser);
    }

    private void changeLogin() throws SQLException
    {
        if(authedUser == null) {
            System.out.println("Вы не авторизованы");
            return;
        }

        String login = scanner.nextLine();
        if(UserEntity.isLoginIncorrect(login)) {
            System.out.println("Некоректный Логин");
            return;
        }

        authedUser.setLogin(login);
        userEntityManager.update(authedUser);
        System.out.println("Логин успешно обновлен " + authedUser);
    }

    private void deleteUser() throws SQLException
    {
        if(authedUser == null) {
            System.out.println("Вы не авторизованы");
            return;
        }

        userEntityManager.deleteById(authedUser.getId());
        authedUser = null;
        System.out.println("Аккаунт успешно удален");
    }
}
