package org.orgname.app.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test
{
    public static void main(String[] args)
    {
        //System.out.println(System.currentTimeMillis());
        //System.out.println(new Date().getTime());

        //инициализировали объкт даты с текущей датой и временем
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss:SSS z");
        System.out.println(format1.format(date));

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy.MM.dd");
        System.out.println(format2.format(date));

        SimpleDateFormat format3 = new SimpleDateFormat("HH:mm:ss");
        System.out.println(format3.format(date));

        String birthday = "18.07.2000";
        SimpleDateFormat format4 = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date date2 = format4.parse(birthday);
            System.out.println(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
