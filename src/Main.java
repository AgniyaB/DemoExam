import java.io.*;
import java.nio.file.*;
import java.util.Random;

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

    public static final File TEXT_FILE = new File("text.txt");
    public static final Random RANDOM = new Random();


    public static void main(String[] args)
    {
        /*File file = new File("text.txt");
        File dir = new File("/test");

        file.exists();
            file.isDirectory();
            file.isFile();

        try {
            file.createNewFile();
            dir.mkdir();
            dir.mkdirs(); //создает все папки на пути
        } catch (IOException e) {
            e.printStackTrace();
        }

        String s = file.getName(); //название + расширение
        file.canExecute();
        file.canRead();
        file.canWrite();
        String s1 = file.getAbsolutePath();
        file.delete();

        if(dir.isDirectory()) {
            File[] files = dir.listFiles();
        }*/

        /*InputStream is;
        OutputStream os;

        Reader r;
        Writer w;

        InputStreamReader isr;
        OutputStreamWriter osw;*/

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

        /*try {
            FileWriter fw = new FileWriter(TEXT_FILE, true);

            fw.write("\n");
            for(int i=1; i<10; i++) {
                fw.write(String.valueOf(RANDOM.nextInt(i)));
            }
            fw.write("finish\n");

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try(BufferedReader br = new BufferedReader(new FileReader(TEXT_FILE)))
        {
            StringBuilder sb = new StringBuilder();
            String s;
            while((s = br.readLine()) != null) {
                sb.append(s);
            }
            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try(BufferedWriter bw = new BufferedWriter(new FileWriter(TEXT_FILE, true)))
        {
            List<String> list = Arrays.asList("ihfgefgfe", "34324334", "43543fgrfr3g");
            for(String s : list) {
                bw.write(s);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try {

            Path path1 = Paths.get("first.txt");
            Path path2 = Paths.get("second.txt");

            Files.copy(path1, path2);
            Files.copy(
                    path1, path2,
                    StandardCopyOption.COPY_ATTRIBUTES,
                    StandardCopyOption.REPLACE_EXISTING
            );

            BufferedWriter bw = Files.newBufferedWriter(path1);
            BufferedReader br = Files.newBufferedReader(path2, StandardCharsets.US_ASCII);

            List<String> list1 = Files.readAllLines(path1);
            List<String> list2 = Files.readAllLines(path1, StandardCharsets.US_ASCII);

        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    /*private static void readFile() throws IOException
    {
        try(FileReader fr = new FileReader("tewefet")) {
            //...
        }
    }*/

}
