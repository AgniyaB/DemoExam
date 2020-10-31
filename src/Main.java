import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Executable;
import java.util.Scanner;

public class Main {
    /*
    Book
    - int id (>0)
    - String title (length > 3 & <20)
    - String author (length > 3 & <20)

    BookReadException extends Exception

    Library
    - String title
    - List<Book> books
    - public void readBook()
        запрашивает из консоли чтение книги
        проверяет поля на корректность
        если поля для книги введены некоретно
        выбрасывает ошибку BookReadException
        если верно, то добавляет книгу

    создать библиотеку
    и в цикле прочитать несколько книг
     */

    public static void main(String[] args)
    {
        Library lib = new Library("назвнание4зшукпмркуп");

        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<2; i++) {
            lib.readBook(scanner);
        }
        scanner.close();

        System.out.println(lib);
    }
}
