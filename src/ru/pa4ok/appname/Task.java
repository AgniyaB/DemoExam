package ru.pa4ok.appname;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task
{
    /*
    Book
    - int id
    - String title (от 3 до 20 символов)
    - String author (от 5 до 30 символов)

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
        List<Book> books = new ArrayList<>();

        for(int i=0; i<2; i++) {
            try {
                Book book = readBook();
                books.add(book);
                System.out.println("Книги успешно добавлена: " + book);
            } catch (BookReadException e) {
                System.out.println("Ошибка при чтении книги");
                e.printStackTrace();
            }
        }

        System.out.println(books);
    }

    private static Book readBook()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Введите id книги: ");
        String idString = scanner.nextLine();
        System.out.printf("Введите название книги: ");
        String title = scanner.nextLine();
        System.out.printf("Введите автора книги: ");
        String author = scanner.nextLine();

        int id;
        try {
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new BookReadException("Введен некорректный id", e);
        }

        if(title.length() < 3 || title.length() > 20) {
            throw new BookReadException("Название книги введено неверно");
        }

        if(author.length() < 5 || author.length() > 30) {
            throw new BookReadException("Автор книги введен неверно");
        }

        return new Book(id, title, author);
    }
}
