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
        Library lib1 = new Library("feoihgrewuhgwreuihgerg");
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
