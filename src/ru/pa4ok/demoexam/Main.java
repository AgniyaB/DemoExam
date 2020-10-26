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
    Book
    - int id
    - String title
    - String author

    Library
    - String title
    - List<Book> books
    - void save()
        1 строка это название
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
        /*File file = new File("text.txt");
        File dir = new File("/test");

        file.isDirectory();
        file.isFile();

        file.isHidden();
        file.canExecute();
        file.canRead();
        file.canWrite();

        file.exists();
        file.getAbsolutePath();

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(!dir.exists()) {
            dir.mkdir(); //только 1 конечную
            dir.mkdirs(); //создать все папки на пути
        }

        File[] files = dir.listFiles();*/

        /*InputStream is;
        OutputStream os;

        InputStreamReader isr;
        OutputStreamWriter osw;*/


        /*try {
            FileWriter fw = new FileWriter(TEXT_FILE); //, true);

            fw.write('c');
            fw.write("324332432434");

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try {
            FileReader fr = new FileReader(TEXT_FILE);

            StringBuilder sb = new StringBuilder();
            int i;
            while((i = fr.read()) != -1) {
                sb.append((char)i);
            }
            System.out.println(sb);

            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try(BufferedReader br = new BufferedReader(new FileReader(TEXT_FILE))) {

            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s).append('\n');
            }
            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try {
            read();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try(BufferedWriter bw = new BufferedWriter(new FileWriter(TEXT_FILE))) {

            List<String> list = Arrays.asList("2142121", "gwregrgr", "45344tg3g443g");
            for(String s : list) {
                bw.write(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try {

            BufferedReader br = Files.newBufferedReader(Paths.get("text.txt"));
            BufferedWriter bw = Files.newBufferedWriter(Paths.get("text.txt"));

            Files.copy(
                    Paths.get("first"),
                    Paths.get("second"),
                    StandardCopyOption.COPY_ATTRIBUTES,
                    StandardCopyOption.REPLACE_EXISTING
            );

            /*byte[] bytes = null;
            String s = new String(bytes, Charset.forName("CP1251"));*/

            List<String> list1 = Files.readAllLines(Paths.get("text.txt"));
            List<String> list2 = Files.readAllLines(Paths.get("text.txt"), Charset.forName("CP1251"));
            List<String> list3 = Files.readAllLines(Paths.get("text.txt"), StandardCharsets.UTF_8);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void read() throws IOException
    {
        try(FileReader fr = new FileReader("tesswfij"))
        {
            fr.read();
            //...
        }
    }
}
