package ru.pa4ok.demoexam;

import java.io.IOException;
import java.util.Scanner;

public class Main
{
    /*
    Book
    - int id
    - String title
    - String author

    Library
    - String title
    - List<Book> books
    - void save()
        1 строка это название (title)
        остальные строки это кники
        формат для книг id;title;author
    - void load()
        будет работать в связке с пустым конструктором

    файл для чтения и записи new File("lib.txt")

    создать бибилитеку
    заполнить книгами
    сохранить и завершить работу программы
    после чего запустить
    создать бибилиотеку из пустого конструтора
    и загрузить сохранные книги
     */

    public static void main(String[] args)
    {
        /*Library lib = new Library("lib super title");
        for(int i=0; i<10; i++) {
            lib.getBooks().add(new Book(i, "title-" + i, "author-" + i));
        }

        try {
            lib.save();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        Library lib = new Library();

        System.out.println(lib);
        try {
            lib.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(lib);
    }
}
