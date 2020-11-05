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
    - String title
    - List<Book> books
    - public static void save(String path, Library lib)
        сериализует lib в файл по адресу path
        через механизм интерфейса Externalizable
    - public static Library load(String path)
        десериализует бибилиотеку из файла по адресу path
        и возвращает ее
    */

    public static void main(String[] args)
    {
        Library lib1 = new Library("iwrghirughihg3h54g");
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
