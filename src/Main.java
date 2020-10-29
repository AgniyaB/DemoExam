import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Executable;

public class Main
{
    /*
    Exception
    обязательны для обработки

    RuntimeException extends Exception
    не обязательны для обработки
     */

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
        /*Integer.parseInt("1e0");

        try {
            Integer.parseInt("1e0");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }*/


        /*try {
            FileReader fr = new FileReader("text.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        /*try {
            FileReader fr = new FileReader("text.txt");
            Integer.parseInt("1e0");

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }*/

        /*try {
            FileReader fr = new FileReader("text.txt");
            Integer.parseInt("1e0");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            //вызывается всегда
            //для справки, юзать его не будем
        }*/

        try {
            testMyException();
        } catch (MyException e) {
            e.printStackTrace();
        }

        try {
            //...
            if(true) {
                throw new MyRuntimeException("34324234");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //testMyRuntimeException();
    }

    public static void testMyException() throws MyException {
        throw new MyException();
    }

    public static void testMyRuntimeException()
    {
        throw new MyRuntimeException();
    }

    public static void test1(int i) throws MyException {
        if(i < 0)  {
            throw new MyException("меньше 0");
        }
    }

}
