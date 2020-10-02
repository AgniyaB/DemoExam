package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int intValue; //0
        Integer integer; //null

        float floatValue = 443.43234324F;
        double doubleValue =  4433424.000D;
        boolean booleanValue1; //false
        boolean booleanValue2 = true;
        char charValue = 'r';
        /*
        Float
        Double
        Boolean
        Char
         */

        /*String s = "4234334234";
        System.out.println(s.substring(2, 5));
        System.out.println(s.contains("lnger"));
        System.out.println(s.contains("343"));
        */

        /*System.out.println(doubleValue > floatValue);
        String s1 = "wfeefewf";
        String s2 = "wfeefewF";
        //if(s1 == s2) //некоректно
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));*/

        /*String s = "4324";
        int i = Integer.parseInt(s);
        System.out.println(3 + i);
        *//*
        Float.parseFloat()
        Double.parseDouble()
        ...
         */

        //int[] intArr; //null
        /*int[] intArr = new int[10];
        System.out.println(intArr[0]);

        Integer[] integers = new Integer[10];
        System.out.println(integers[0]);

        for(int i=0; i<intArr.length; i++) {
            intArr[i] = i + 3;
        }

        for(int i : intArr) { //сюда копии объектов из массива
        }

        System.out.println(Arrays.toString(intArr));*/

        /*Student student = new Student("Vasya", 15, 4);
        //System.out.println(student.age);
        System.out.println(student);
        student.setName("Petya");
        System.out.println(student);
        */

        /*Scanner scanner = new Scanner(System.in);

        String s  = scanner.nextLine();
        //System.out.println(s.toUpperCase());
        System.out.println(5 + Integer.parseInt(s));
        System.out.println(5 + scanner.nextInt());

        scanner.close();*/
    }
}

//область видимости этот файл и другие файлы из этого пакета
class NewMain
{

}

