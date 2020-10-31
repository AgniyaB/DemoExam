import java.io.*;
import java.util.ArrayList;
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
        сериализовать lib в файл по пути path
    - public static Library load(String path)
        десериализовать библиотеку из файла по пути path
        и вернуть ее

    методы статичные + пробрасывают исключения наверх
     */

    public static void main(String[] args)
    {
        long l1 = System.currentTimeMillis();
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.dat"))) {

            Book book = new Book(1, "vozna i mir", "pushkin");
            for(int i=0; i<1000; i++) {
                oos.writeObject(book);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.dat"))) {

            List<Book> list = new ArrayList<>();
            for(int i=0; i<1000; i++) {
                Book book = (Book)ois.readObject();
                list.add(book);
            }
            System.out.println(list.size());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - l1);

        long l2 = System.currentTimeMillis();
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("new-book.dat"))) {

            NewBook book = new NewBook(1, "vozna i mir", "pushkin");
            for(int i=0; i<1000; i++) {
                oos.writeObject(book);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("new-book.dat"))) {

            List<NewBook> list = new ArrayList<>();
            for(int i=0; i<1000; i++) {
                NewBook book = (NewBook)ois.readObject();
                list.add(book);
            }
            System.out.println(list.size());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - l2);
    }
}
