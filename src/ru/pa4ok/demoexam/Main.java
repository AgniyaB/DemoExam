package ru.pa4ok.demoexam;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        /*int intValue = 0;
        Integer integer = null;

        float floatValue = 43324324.555F;
        double doubleValue = 34234324.00D;
        boolean booleanValue = true;
        char charValue = 'f';
        *//*
        Float
        Double
        Boolean
        Char
         *//*

        String s1 = "wdqdwwqD";
        System.out.println(s1.substring(2, 5));
        String s2 = "wdqdwwqd";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        System.out.println(floatValue > intValue);

        String s3 = "44123413";
        int i1 = Integer.parseInt(s3);
        System.out.println(i1 + 10);
        */

        /*int[] intArr = new int[10];
        System.out.println(intArr[0]);

        Integer[] integers = new Integer[10];
        System.out.println(integers[0]);

        for(int i=0; i<intArr.length; i++) {
            intArr[i] = 3 + i;
        }

        for(int i : intArr) {
            System.out.printf(i + " ");
        }
        System.out.println();*/

        //InClass test = new InClass();

        /*Student student = new Student("Vasya", "Grin4pun");
        System.out.println(student);*/

        //Scanner scanner = new Scanner(System.in);

        //String s = scanner.next();
        //System.out.println(s);
        /*int i = Integer.parseInt(scanner.next());
        int j = scanner.nextInt();
        System.out.println(i + j);
        System.out.println("" + i + j);
        System.out.println(String.valueOf(i) + String.valueOf(j));
        scanner.close();*/

        System.out.println(Student.CITY);
        System.out.println(Math.PI);
        System.out.println(Math.cos(Math.PI));
        Student.staticTest();
    }

    public static class StaticClass
    {

    }
}

class InClass
{

}
