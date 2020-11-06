package ru.pa4ok.demoexam;

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
    - String libTitle
    - List<Book> books
    - void save()
        первая строка это название (libTitle)
        остальные строки это кники
        формат для книг id;title;author
    - void load()
        будет работать в связке с пустым конструктором

    файл для чтения и записи new File("lib.txt")

    создать бибилитеку, заполнить книгами
    сохранить и завершить работу программы
    после чего запустить
    создать бибилиотеку из пустого конструтора
    и загрузить сохранные книги
     */

    public static void main(String[] args)
    {
        Library lib1 = new Library("super library title 1");
        for(int i=0; i<10; i++) {
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

        } catch (IOException e) {
            e.printStackTrace();
        }


        /*File file = new File("text.txt");
        File dir = new File("C:\\Users\\Student\\Desktop\\Test\\test");

        file.exists();
            file.isDirectory();
            file.isFile();
            file.canExecute();
            file.canWrite();
            file.canRead();
            file.isHidden();

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(!dir.exists()) {
            dir.mkdir();
            dir.mkdirs(); //создает все отстуствующие папки на пути
        }

        String name = file.getName();
        long lastChangeMills = file.lastModified();

        System.out.println(file.getAbsolutePath());

        file.delete();*/

        /*InputStream is;
        OutputStream os;

        Reader r;
        Writer w;

        InputStreamReader isr;
        OutputStreamWriter osw;*/

        /*try {
            FileWriter fw = new FileWriter("text.txt");//, true);

            String s = ";wefkj43ry437yf43bfw;ohf3rh34f\noewfh4f44купрпкпшгп'neoifohfe\n";
            *//*for(char c : s.toCharArray()) {
                fw.write(c);
            }*//*
            fw.write(s);

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            long l1 = System.currentTimeMillis();
            FileReader fr = new FileReader(new File("text.txt"));

            StringBuilder sb = new StringBuilder();
            int i;
            while((i = fr.read()) != -1) {
                sb.append((char)i);
            }
            System.out.println((System.currentTimeMillis() - l1) + " " + sb.length());

            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try {
            long l2 = System.currentTimeMillis();
            BufferedReader br = new BufferedReader(new FileReader("text.txt"));

            StringBuilder sb = new StringBuilder();
            String s;
            while((s = br.readLine()) != null) {
                sb.append(s).append('\n');
            }
            System.out.println((System.currentTimeMillis() - l2) + " " + sb.length());

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("text.txt")))
        {
            String[] strings = {"wefwkeofboew2f", "43954briu4f", "lirgh54th5"};
            for(String s : strings) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try {
            Path path = Paths.get("text.txt");

            Files.copy(
                    path,
                    Paths.get("new-txt.txt")
            );

            Files.copy(
                    path,
                    Paths.get("new-txt.txt"),
                    StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.COPY_ATTRIBUTES
            );

            Files.createLink(Paths.get("/test1"), Paths.get("/test2"));

            BufferedWriter fw = Files.newBufferedWriter(path);
            BufferedReader br = Files.newBufferedReader(path);

            BufferedWriter fw1 = Files.newBufferedWriter(path, Charset.forName("CP1251"));
            BufferedReader br1 = Files.newBufferedReader(path, Charset.forName("CP1251"));

            List<String> list1 = Files.readAllLines(path);
            List<String> list2 = Files.readAllLines(path, Charset.forName("CP1251"));

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    /*private static void readFile() throws IOException
    {
        try(FileReader fr = new FileReader("geegregre")) {
            //...
        }
    }*/

}
