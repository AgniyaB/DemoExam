package org.orgname.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate
{
    public static void main(String[] args)
    {
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());

        Date date = new Date();

        //System.out.println(date);

        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss:SSS z");
        System.out.println(format.format(date));

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format1.format(date));

        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
        System.out.println(format2.format(date));

        String birthday = "18.07.2000";
        SimpleDateFormat format3 = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date date1 = format3.parse(birthday);
            System.out.println(format.format(date1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
