package ru.pa4ok.appname;

import ru.pa4ok.appname.database.entity.DateEntity;
import ru.pa4ok.appname.database.entity.FilmEntity;
import ru.pa4ok.appname.database.entity.UserEntity;
import ru.pa4ok.appname.database.manager.DateEntityManager;
import ru.pa4ok.appname.database.manager.FilmEntityManager;
import ru.pa4ok.appname.database.manager.UserEntityManager;
import ru.pa4ok.appname.util.MysqlDatabase;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main
{
    public static void main(String[] args)
    {
        MysqlDatabase database = new MysqlDatabase("116.202.236.174", "DemoExam", "DemoExam", "DemoExam");
        UserEntityManager userEntityManager = new UserEntityManager(database);
        FilmEntityManager filmEntityManager = new FilmEntityManager(database);
        DateEntityManager dateEntityManager = new DateEntityManager(database);

        /*//System.out.println(System.currentTimeMillis());
        //System.out.println(new Date().getTime());

        //объект инициализируется с текущей датой и временем
        Date date1 = new Date();
        System.out.println(date1);

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss:SSS z");
        System.out.println(format1.format(date1));

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy.MM.dd");
        System.out.println(format2.format(date1));

        SimpleDateFormat format3 = new SimpleDateFormat("HH:mm:ss");
        System.out.println(format3.format(date1));


        String birthday = "18/07~2000";
        SimpleDateFormat format4 = new SimpleDateFormat("dd/MM~yyyy");
        try {
            Date date2 = format4.parse(birthday);
            System.out.println(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        //------------------------------------------------------------------------------------//

        /*String birthday = "18/07~2000";
        SimpleDateFormat format4 = new SimpleDateFormat("dd/MM~yyyy");
        try {
            Date date = format4.parse(birthday);
            DateEntity dateEntity = new DateEntity(date);
            dateEntityManager.add(dateEntity);
            System.out.println(dateEntity);

        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }*/

        try {
            System.out.println(dateEntityManager.getById(11));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
