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
    Book
    - int id
    - String title
    - String author

    Library
    - String title
    - List<Book> books
    - void save()
        первая строка это название (title)
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
        /*Library lib1 = new Library("oeiwiubibnefwe");
        for(int i=1; i<10; i++) {
            lib1.getBooks().add(new Book(i, "title-" + i, "author-" + i));
        }
        try {
            lib1.save();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Library lib2 = new Library();
            System.out.println(lib2);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        try {
            test2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test1()
    {
        try(BufferedWriter bw = Files.newBufferedWriter(Paths.get("lib.txt"))) {

            bw.write("ewpihfef");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test2() throws IOException
    {
        try(BufferedWriter bw = Files.newBufferedWriter(Paths.get("lib.txt"))) {
            bw.write("ewpihfef");
        }
    }
}
