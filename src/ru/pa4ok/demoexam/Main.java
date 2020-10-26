package ru.pa4ok.demoexam;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        /* это мы пропускаем и идем выше
        InputStream is;
        OutputStream os;
        InputStreamReader osr;
        OutputStreamWriter osw;*/

        File file = new File("text.txt");
        /*if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        /*try {
            FileReader fr = new FileReader(file);
            long startMills1 = System.currentTimeMillis();
            StringBuilder sb1 = new StringBuilder();
            int i = 0;
            while((i = fr.read()) != -1) {
                sb1.append((char)i);
            }
            System.out.println((System.currentTimeMillis() - startMills1) + " " + sb1.length());
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try {
            FileWriter fw = new FileWriter(file); //если сделать  new FileWriter(file, true), будет записывать в конец файла
            String s = "ewrfhuwehefwhfew\r\newogi45iu43t34ft43\r\nwfeoefh443";
            for(char c : s.toCharArray()) {
                fw.write(c);
            }
            //fw.write(s);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                long startMills2 = System.currentTimeMillis();
                StringBuilder sb2 = new StringBuilder();
                String s = null;
                while((s = br.readLine()) != null) {
                    sb2.append(s);
                }
                System.out.println((System.currentTimeMillis() - startMills2) + " " + sb2.length());
                br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try {
            FileWriter fw = new FileWriter("test_new.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            List<String> list = Arrays.asList("43244", "w;efjewfh45hr43f", "wfewofh34324");
            for(String s : list) {
                bw.write(s);
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try {
            /*BufferedReader br = Files.newBufferedReader(Paths.get("test.txt"));
            br.close();*/

            /*Files.copy(
                    Paths.get("fileFrom"),
                    Paths.get("fileTo"),
                    StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.COPY_ATTRIBUTES
            );*/

            /*long startMills3 = System.currentTimeMillis();
            List<String> filesStrings = Files.readAllLines(Paths.get("text.txt"));
            System.out.println((System.currentTimeMillis() - startMills3) + " " + filesStrings.size());*/

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*try(FileReader fr = new FileReader(file)) { //по завершению блока try cache java сама закроет ваш реадер
            int i = fr.read();
            System.out.println((char)i);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /*//если нужно несколько сразу
        try(
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)
        ) {
            int i = fr.read();
            System.out.println((char)i);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    private void readFile(String file) throws IOException
    {
        //в данном случае try не обрабатывает ошибку
        //а только служит для автозакрытия ресурсов
        try(FileReader fr = new FileReader(file)) {
            fr.read();
        }
    }
}
