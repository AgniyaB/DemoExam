package ru.pa4ok.demoexam;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //Exceptiom обрабатывать надо всегда
        //RuntimeException по желанию

        //необязательное исключение
        /*int i = 10;
        try {
            i += Integer.parseInt("2");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            i = 0;
        }
        System.out.println(i); */

        //обязательное исключение
        /*File file = new File("test.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try {
            //блок с возможной ошибкой
        } catch (Exception e) {
            e.printStackTrace();
            //действия по ошибке
        } finally {
            //вызывается вне зависимости от ошибки
        }*/

        /*try {
            createFile("4324324");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }*/

        /*canner scanner = null;
        int i = 10;
        try {
            scanner = new Scanner(System.in);
            i += scanner.nextInt();
        } catch(Exception e) {
            i = 0;
        } finally { //в основном блок finaly служит для закрытия ресурсов
            scanner.close();
        }
        System.out.println(i);*/

        System.out.println(readStudent());
    }

    /*private static void createFile(String fileName) throws IOException, NumberFormatException
    {
        File file = new File(fileName);
        if(!file.exists()) {
            file.createNewFile();
        }

        Integer.parseInt("ewoergre");

    }
*/
    public static Student readStudent()
    {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age;

        while(true) {
            try {
                age = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Возраст введен неверно");
            }
        }

        scanner.close();

        return new Student(name, age);
    }
}
