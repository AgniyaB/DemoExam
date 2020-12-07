package org.orgname.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test
{
    public static void main(String[] args)
    {
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss:SSS z");
        System.out.println(dateFormat.format(date));

        String birthday = "18.07.2000";
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd.MM.yyyy");

        try {
            Date date1 = dateFormat1.parse(birthday);
            System.out.println(date1.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
