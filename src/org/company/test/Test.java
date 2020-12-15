package org.company.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test
{
    public static void main(String[] args)
    {
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());

        Date date1 = new Date(); //создает объект даты с текущеми показателями
        System.out.println(date1);

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss:SSS z");
        System.out.println(format1.format(date1));

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format2.format(date1));

        String birthday = "18/07/2000";
        SimpleDateFormat format3 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date2 = format3.parse(birthday);
            System.out.println(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
