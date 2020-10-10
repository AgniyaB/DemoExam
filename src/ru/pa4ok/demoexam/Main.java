package ru.pa4ok.demoexam;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main
{
    /*
    Exception
    требует обязательной обработки

    RuntimeException
    не требуют обязательное обработки
     */

    public static void main(String[] args)
    {
        /*int i = 10;
        int j = 0;

        System.out.println(i / j);*/
        //Integer.parseInt("4еак");

        //FileReader reader = new FileReader("file.txt");

        /*int i = 10;
        try {
            i += Integer.parseInt("wdf");
        } catch(NumberFormatException e) {
            e.printStackTrace();
            i = -1;
        } finally {
            //блок final не обязателен
            //в основном используется для закрытия каких-то ресурсов
        }
        System.out.println(i);*/

        //testError1();

        //выбрасывать ошибки из метода main не рекомендуется
        /*try { //обоаботали проброшенную ошибку
            testError2();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        //testError3(null);
        //testError3("testtest");

        try {
            testError4(null);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ошибка успешно обработана");
        }
    }

    //обработка ошибки
    private static void testError1()
    {
        try {
            FileReader reader = new FileReader("file.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //проброс ошибки наверх
    private static void testError2() throws FileNotFoundException {
        FileReader reader = new FileReader("file.txt");
    }

    private static void testError3(String s)
    {
        if(s == null) {
            throw new NullPointerException("строка не задана");
        } else {
            System.out.println(s.toUpperCase());
        }
    }

    private static void testError4(String s) throws Exception {
        if(s == null) {
            throw new NullStringException();
        } else {
            System.out.println(s.toUpperCase());
        }
    }

    /*
    Book
    - int id (>0)
    - String name (только русские символы, от 3 до 20 по длине)
    - String author (только русские символы, от 3 до 30 по длине)

    BookReadException extends Exception
    - все базовые конструкторы сгенерировать

    Статичный метод в классе Main
    private static readBook() throws BookReadException
    который запрашивает у пользователя из консоли
    данные для создания Book и проверяет их корректность
    если что-то не корректно, пробрасывает наверх ошибку

    в методе main создать List<Book>
    запросить чтение нескольких книг
    с обработкой ошибки
     */
}
