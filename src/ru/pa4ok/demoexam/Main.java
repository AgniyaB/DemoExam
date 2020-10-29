package ru.pa4ok.demoexam;

import java.io.*;

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
    - public static void save(String path, Library libs)
        сериализовать бибилитеку в файл path
        через методы интерфейса Externalizable
    - public static Library load(String path)
        должен десереализовать библиотеку из файла path
        и вернуть ее
     */

    public static void main(String[] args)
    {
        /*Book book = new Book(1, "some title", "some author");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book-1.dat"))) {

            oos.writeObject(book);

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book-1.dat"))) {

            Book book = (Book) ois.readObject();
            System.out.println(book);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        //------------------------------------------------------------------------------------------//

        SuperBook book = new SuperBook(1, "some title", "some author");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("super-book-1.dat"))) {

            oos.writeObject(book);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("super-book-1.dat"))) {

            SuperBook book1 = (SuperBook) ois.readObject();
            System.out.println(book1);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
