package ru.pa4ok.demoexam;

import java.io.IOException;

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
        Library lib1 = new Library("title super 1");
        for(int i=0; i<10; i++) {
            lib1.getBooks().add(new Book(i, "title-" + i, "author-" + i));
        }
        try {
            Library.save("lib.dat", lib1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Library lib2 = Library.load("lib.dat");
            System.out.println(lib2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
