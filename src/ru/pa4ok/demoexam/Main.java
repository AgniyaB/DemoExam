package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.database.entity.UserEntity;
import ru.pa4ok.demoexam.database.manager.UserEntityManager;
import ru.pa4ok.demoexam.util.MysqlDatabase;

import java.sql.SQLException;
import java.util.List;

public class Main
{
    /*
    116.202.236.174
    DemoExam
     */

    public static void main(String[] args)
    {
        MysqlDatabase database = new MysqlDatabase("116.202.236.174", 3306, "DemoExam", "DemoExam", "DemoExam");
        UserEntityManager userEntityManager = new UserEntityManager(database);

        try {

            //System.out.println(userEntityManager.addUser(new UserEntity("Pa4ok", "12345")));
            //System.out.println(userEntityManager.getUserById(7));

            List<UserEntity> allUsers = userEntityManager.getAllUsers();
            System.out.println(allUsers);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
