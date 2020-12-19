package ru.pa4ok.appname;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main
{
    /*
    Ошибки/исключения делятся на 2 типа
    обязательные к обработки и нет

    если класс ошибки наслелует RuntimeException - то она не обязательна к обработке
    если не наследует то обязаетельна
     */
    public static void main(String[] args) //если выбросить ошибку из метода main то программа завершит работу
    {
        /*try {

            int i = Integer.parseInt("43435");
            System.out.println(i);

            String s = null;
            test(s);

        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("ошибка обработана 1");
            e.printStackTrace();
        } */

        //readFile();

        /*try {
            readFile2();
        } catch (FileNotFoundException e) {
            System.out.println("ошибка обработана");
            e.printStackTrace();
        }*/

        System.out.println(checkString("2v9kfnrvre0"));

        //System.out.println(checkString(null));

        //System.out.println(checkString2(null));

        try {
            System.out.println(checkString3(null));
        } catch (MyException e) {
            System.out.println("ошибка обработана");
            e.printStackTrace();
        }
    }

    private static void readFile()
    {
        try {
            FileReader fr = new FileReader("test.txt");
        } catch (FileNotFoundException e) {
            System.out.println("ошибка обработана");
            e.printStackTrace();
        }
    }

    private static void readFile2() throws FileNotFoundException
    {
        FileReader fr = new FileReader("test.txt");
    }

    private static boolean checkString(String s)
    {
        if(s == null) {
            throw new NullPointerException("ппришла нулевая строка");
        }

        if(s.charAt(2) == '9') {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkString2(String s)
    {
        if(s == null) {
            throw new MyRuntimeException("ппришла нулевая строка");
        }

        if(s.charAt(2) == '9') {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkString3(String s) throws MyException
    {
        if(s == null) {
            throw new MyException("ппришла нулевая строка");
        }

        if(s.charAt(2) == '9') {
            return true;
        } else {
            return false;
        }
    }

    private static boolean test(String s) {
        return s.equals("oehefwhfew");
    }
}

