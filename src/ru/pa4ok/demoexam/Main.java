package ru.pa4ok.demoexam;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class Main
{
    /*
    Book
    - int id
    - String title
    - String author

    Library
    - String name
    - List<Book> books
    - void save()
        1 строка это название
        остальные строки это кники
        формат для книг id;title;author
    - void read()
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
        /*Library library = new Library("Библиотекв");
        for(int i=0; i<10; i++) {
            library.getBooks().add(new Book(i, "title-" +i, "author-" + i));
        }
        System.out.println(library);

        try {
            library.save();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        Library library = new Library();
        try {
            library.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(library);


        /*try {
            Files.readAllLines(Paths.get("test"), StandardCharsets.US_ASCII);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
