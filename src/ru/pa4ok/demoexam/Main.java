package ru.pa4ok.demoexam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main
{
    /*
    Book implements Externalizable
    - int id
    - String title
    - String author

    Library implements Externalizable
    - String name
    - List<Book> books
    - public static void save(String path)
        сериализовать библиотеку в файл
        через методы интерфейса Externalizable
    - public static Library load(String path)
        прочить сериализованную в файл библиотеку

    //методы статичные, чтобы была вот такая логиках
    //Library lib = Library.load("lib.txt");
     */


    public static void main(String[] args)
    {
        /*Book book = new Book("super book title", "vasya pupkin");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book1.dat"))) {

            oos.writeObject(book);

        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book1.dat"))) {

            Book book = (Book)ois.readObject();
            System.out.println(book);

        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //----------------------------------------------------------------------------//

        /*SuperBook book = new SuperBook(1, "super book title", "vasya pupkin");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("super-book1.dat"))) {

            oos.writeObject(book);

        } catch (Exception e) {
            e.printStackTrace();
        }*/

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("super-book1.dat"))) {

            SuperBook book = (SuperBook)ois.readObject();
            System.out.println(book);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
