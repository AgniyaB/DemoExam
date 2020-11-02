package ru.pa4ok.demoexam;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class Main
{
    private static final File TEXT_FILE = new File("text.txt");

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
    - public static Library load(String path)
        десериализует Library из файла по адресу path
        и возвращает его


    создать бибилитеку, заполнить книгами
    сохранить и завершить работу программы
    запустить и загрузить бибилотеку через
    метод Library.load()
     */

    public static void main(String[] args)
    {
        /*try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lib.dat"))) {

            oos.writeObject(new Book(1, "title3oighe", "vasya228"));
            oos.writeObject("fejfoiewfjew");

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

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lib.dat"))) {

            oos.writeObject(new NewBook(1, "title3oighe", "vasya228"));
            oos.writeObject("fejfoiewfjew");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lib.dat"))) {

            NewBook book = (NewBook) ois.readObject();
            System.out.println(book);
            String s = (String) ois.readObject();
            System.out.println(s);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
