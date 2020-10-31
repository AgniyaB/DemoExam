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
        /*File file = new File("text.txt");
        File dir = new File("/dir");

        dir.exists();
        file.exists();
            file.isDirectory();
            file.isFile();
            file.isHidden();
            file.canRead();
            file.canWrite();
            file.canExecute();

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(!dir.exists()) {
            dir.mkdir();
            dir.mkdirs(); //создаст все недостающие папки на пути
        }

        if(dir.isDirectory()) {
            File[] files = dir.listFiles();
        }

        String name = file.getName(); //имя + расширение
        String path = file.getAbsolutePath();

        file.delete();*/

        /*InputStream is;
        OutputStream os;

        Reader r;
        Writer w;

        InputStreamReader isr;
        OutputStreamWriter osw;*/

        /*try {
            FileWriter fw = new FileWriter("text.txt");//, true);

            String s = "ewhfgewiewfefwefw\noeihfeh435h435\n45t5yt45gb4i5g";
            fw.write(s);

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try {
            long startMills = System.currentTimeMillis();

            FileReader fr = new FileReader("text.txt");

            StringBuilder sb = new StringBuilder();
            int i;
            while((i = fr.read()) != -1) {
                sb.append((char)i);
            }
            String s = sb.toString();
            //System.out.println(sb);

            fr.close();

            System.out.println(s.length() + " " + (System.currentTimeMillis() - startMills));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try {
            long startMills = System.currentTimeMillis();

            BufferedReader br = new BufferedReader(new FileReader("text.txt"));

            StringBuilder sb = new StringBuilder();
            String s;
            while((s = br.readLine()) != null) {
                sb.append(s);
                sb.append('\n');
            }
            String s1 = sb.toString();

            br.close();
            System.out.println(s1.length() + " " + (System.currentTimeMillis() - startMills));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("text.txt"));

            String[] arr = {"oljkwhgeog", "rekrgrwgwr", "oheruhgrg"};
            for(String s : arr) {
                bw.write(s);
                bw.newLine();
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try {

            Path path = Paths.get("text.txt");

            //List<String> stringList = Files.readAllLines(Paths.get(path);
            //List<String> stringList = Files.readAllLines(Paths.get(path), Charset.forName("CP1251"));

            //byte[] bytes = Files.readAllBytes(path);

            /*Files.copy(
                    path,
                    Paths.get("new-file.txt")
            );

            Files.copy(
                    path,
                    Paths.get("new-file.txt"),
                    StandardCopyOption.COPY_ATTRIBUTES,
                    StandardCopyOption.REPLACE_EXISTING
            );*/


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
