import java.io.IOException;

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
        сериализовать lib в файл по пути path
    - public static Library load(String path)
        десериализовать библиотеку из файла по пути path
        и вернуть ее

    методы статичные + пробрасывают исключения наверх
     */

    public static void main(String[] args)
    {
        Library lib1 = new Library("ewkfheifewuihfewf");
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
