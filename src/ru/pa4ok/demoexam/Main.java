package ru.pa4ok.demoexam;

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
    - String libTitle
    - List<Book> books
    - public static void save(String path, Library lib)
        сериализует lib в файл по адресу path
        используя механизм интерфейса Externalizable
        Library.save("lib.dat", lib)
    - public static Library load(String path)
        читает из файла по адресу path Library
        и возвращает ее
        Library lib = Library.load("lib.dat")
     */

    public static void main(String[] args)
    {
        /*try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lib.dat"))) {

            Book book = new Book(1,"voina i mir", "pushkin");
            oos.writeObject(book);
            oos.writeObject("giehg54tg45gi64");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lib.dat"))) {

            Book book = (Book) ois.readObject();
            System.out.println(book);
            String s = (String) ois.readObject();
            System.out.println(s);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("super-lib.dat"))) {

            SuperBook book = new SuperBook(1,"voina i mir", "pushkin");
            oos.writeObject(book);
            oos.writeObject("giehg54tg45gi64");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("super-lib.dat"))) {

            SuperBook book = (SuperBook) ois.readObject();
            System.out.println(book);
            String s = (String) ois.readObject();
            System.out.println(s);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
