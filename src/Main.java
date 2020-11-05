import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class Main
{
    /*
    Book implements Externalizable
    - int id
    - String title
    - String author

    Library implements Externalizable
    - String title
    - List<Book> books
    - public static void save(String path, Library lib)
        сериализует lib в файл по адресу path
        через механизм интерфейса Externalizable
    - public static Library load(String path)
        десериализует бибилиотеку из файла по адресу path
        и возвращает ее
    */

    public static void main(String[] args)
    {
        /*Book book = new Book(1, "title", "author");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lib.dat"))) {

            oos.writeObject(book);
            oos.writeObject("rkgnjrgreggr");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lib.dat"))) {

            Book book1 = (Book) ois.readObject();
            String s = (String) ois.readObject();
            System.out.println(book);
            System.out.println(s);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        SuperBook book = new SuperBook(1, "title", "author");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lib-super.dat"))) {

            oos.writeObject(book);
            oos.writeObject("rkgnjrgreggr");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lib-super.dat"))) {

            SuperBook book1 = (SuperBook) ois.readObject();
            String s = (String) ois.readObject();
            System.out.println(book);
            System.out.println(s);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
