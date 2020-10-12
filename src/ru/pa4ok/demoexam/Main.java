package ru.pa4ok.demoexam;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main
{
    /*
        все ошибки которые наследуют класс Exception
        обязательны для обработки

        все ошибки которые наследуют класс RuntimeException
        НЕ обязательны для обработки

    */

    public static void main(String[] args)
    {
        try {
            Integer.parseInt("32e");
            FileReader fr = new FileReader("test");
        } catch (NumberFormatException | FileNotFoundException e) {
            System.out.println("ошибка обработана");
            e.printStackTrace();
        } finally {
            //вызовется в любом случае
            //в основном нужен для закрытия ресурсов
        }

        try {
            //...
        } catch (Exception e) { //отловит любую ошибку
            e.printStackTrace();
        }

        myRuntimeExceptionMethod(5);
    }

    private static void readFile(String fileName) throws FileNotFoundException {
        new FileReader(fileName);
    }

    private static void myExceptionMethod(int i) throws MyException {
        if (i < 0) {
            throw new MyException();
        } else {
            System.out.println(10 * i);
        }
    }

    private static void myRuntimeExceptionMethod(int i) {
        if (i > 0) {
            throw new MyRuntimeException("нужно число меньше 0");
        } else {
            System.out.println(100 * i);
        }
    }
}
