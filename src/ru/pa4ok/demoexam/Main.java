package ru.pa4ok.demoexam;


import sun.nio.cs.StandardCharsets;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
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

    создать бибилитеку, заполнить книгами
    сохранить и завершить работу программы
    запустить и загрузить данные из файла
     */

    public static void main(String[] args)
    {
        //File file = new File("text.txt");
        //File dir = new File("C:\\Users\\Student\\Desktop\\Test\\test");

        /*file.exists();
            file.isFile();
            file.isDirectory();
            file.canExecute();
            file.canWrite();
            file.canRead();*/

        /*if(!file.exists()) {
            try {
                file.createNewFile();
                System.out.println(file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(!dir.exists()) {
            dir.mkdir();
            //dir.mkdirs(); создать все отстуствующие папки на пути
        }*/

        //все файлы в папке
        /*if(dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
        }*/

        //file.delete();

        /*InputStream is;
        OutputStream os;

        Reader r;
        Writer w;

        InputStreamReader isr;
        OutputStreamWriter osw;*/


        /*try {
            FileWriter fw = new FileWriter("text.txt");//, true);

            String s = "kjfhiwefbweifhwefhewf\noewfhwhgwefhwei\nowfhiwefewfef\n\noiefwfe";
            fw.write(s);

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try {
            FileReader fr = new FileReader("text.txt");

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


        /*try(BufferedWriter bw = new BufferedWriter(new FileWriter("text.txt")))
        {
            String[] arr = {"45345454354", "wefjowefjewf", "gwreugt5g45"};
            for(String s : arr) {
                bw.write(s);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try(BufferedReader br = new BufferedReader(new FileReader("text.txt")))
        {
            List<String> list = new ArrayList<>();
            String s;
            while((s = br.readLine()) != null) {
                list.add(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try {

            /*Files.copy(
                    Paths.get("first-file.txt"),
                    Paths.get("second-file.txt")
            );

            Files.copy(
                    Paths.get("first-file.txt"),
                    Paths.get("second-file.txt"),
                    StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.COPY_ATTRIBUTES
            );*/

            //List<String> fileStrings = Files.readAllLines(Paths.get("text.txt"));
            //List<String> fileStrings = Files.readAllLines(Paths.get("text.txt"), Charset.forName("CP1251"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*private static void readFile() throws IOException
    {
        try(FileReader fr = new FileReader("43343")) {
            //...
        }
    }*/
}
