package ru.pa4ok.appname;

import java.util.Scanner;

public class Task
{
    /*
    Book
    - int id
    - String title
    - String author

    BookReadException extends RuntimeException

    сделать в главном классе статичный метод readBook()
    который запрашивает с консоли чтение 3 параметров книги
    и создает ее объект, если все параметры верные
    если есть нарушение выбрасывает BookReadException

    создать List<Book>
    и в цикле прочитать несколько книг
    обрабатывая ошибку внутри итерации цикла
     */

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int i;
        try {
            i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            i = 13;
        }

        i += 10;
        i *= 5;
        System.out.println("new i " + i);
    }
}
