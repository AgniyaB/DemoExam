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
        Library library1 = new Library("ewohuiefhegeif");
        for(int i=1; i<11; i++) {
            library1.getBooks().add(new Book(i, "title-" + i, "author-" + i));
        }

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lib.dat"))) {

            oos.writeObject(library1);

        } catch (IOException e) {
            e.printStackTrace();
        }



        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lib.dat"))) {

            Library library2 = (Library) ois.readObject();
            System.out.println(library2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
