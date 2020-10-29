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
    - String name
    - List<Book> books
    - public static void save(Library library, String path)
        сериализовать библиотеку в файл
        через методы интерфейса Externalizable
    - public static Library load(String path)
        прочить сериализованную в файл библиотеку

    //методы статичные, чтобы была вот такая логиках
    //Library lib = Library.load("lib.txt");
     */


    public static void main(String[] args)
    {
        /*Library lib = new Library("oeufouwfiuh4t");
        for(int i=1; i<11; i++) {
            lib.getBooks().add(new Book(i, "title-" + i, "author-" + i));
        }

        try {
            Library.save(lib, "library.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        try {
            Library lib = Library.load("library.dat");
            System.out.println(lib);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
