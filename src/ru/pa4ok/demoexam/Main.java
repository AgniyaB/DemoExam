package ru.pa4ok.demoexam;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        /*int intValue = 1;
        float floatValue = 3.24242F;
        double doubleValue = 325423532.054354D;
        boolean booleanValue = true;
        char charValue = ' ';
        Integer integer; //null
        //Float
        //Double
        //Bolean
        String string = "efwefwfewf";
        System.out.println(string.substring(2, 7));
        System.out.println(5 + Integer.parseInt("13"));

        int[] intArr = new int[10];
        System.out.println(intArr[0]);

        Integer[] integers = new Integer[10];
        System.out.println(integers[0]);

        for(int i=0; i<intArr.length; i++) {
            intArr[i] = i + 3;
        }
        for(int i : intArr) {
            System.out.printf(i + " ");
        }

        if(doubleValue > intValue) {
            System.out.println("mark1");
        }

        String s1 = "23423432a";
        String s2 = "23423432A";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));*/

       /* Student student = new Student(1, "Vasya");
        System.out.println(student);
        test1(student);
        System.out.println(student);
        student = test2(student);
        System.out.println(student);*/

        //System.out.println(Math.cos(Math.PI));

        //Student.GLOBAL_ID

        /*Scanner in = new Scanner(System.in);

        System.out.println(in.next());
        System.out.println(5 + Integer.parseInt(in.next()));
        System.out.println(5 + in.nextInt());

        in.close();*/
    }

    private static void test1(Student student) {
        student.setName("new name");
    }

    private static Student test2(Student student) {
        student.setName("new name 2");
        return student;
    }

    public static class TestStaticClass
    {

    }
}

/*
class PrivateClass
{

}*/
