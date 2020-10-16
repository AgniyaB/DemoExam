package ru.pa4ok.demoexam;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    /*
    все ошибки которые наследуют Exception
    они обязательны для обработки

    все ошибки которые наследуют RuntimeException
    они НЕ обязательны для обработки
     */

    public static void main(String[] args)
    {

        int i = 5;

        try {
            System.out.println(i + Integer.parseInt("10e"));
            //FileReader fr = new FileReader("fefe");
        } /*catch(Exception e) {
            e.printStackTrace(); отловит любую ошибку
        }*/
        /*catch(NumberFormatException e) {
            e.printStackTrace();
        } можно размещать несклько блоков catch
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }*/
        catch(NumberFormatException/* | FileNotFoundException*/ e) {
            System.out.println("ошибка обработана");
            i = 0;
        } finally {
            //блок который вызывается всегда
            //раньше его использовали для закрытия ресурсов
            //сейчас уже редко используется
        }

        System.out.println(i);

        //readFile1("file.txt");

        //пробросить выше уже некуда
        //если метод main выбрасывает ошибку
        //программа завершает работу
        /*try {
            readFile2("file.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //checkInt(1);
        //checkInt(-1);

        /*try {
            checkInt1(-1);
        } catch (MyException e) {
            e.printStackTrace();
        }*/

    }

    private static void readFile1(String fileName)
    {
        try {
            FileReader fr = new FileReader(fileName);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //проброс ошибки наверх
    private static void readFile2(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        fr.close();
    }

    private static void checkInt(int i)
    {
        if(i < 0) {
            throw new NumberFormatException("число меньше 0");
        }
    }

    private static void checkInt1(int i) throws MyException {
        if(i < 0) {
            throw new MyException("число меньше 0");
        }
    }

    /*
    Library
    - String title
    - Map<Integer, Book> books

    Book
    - int id (>0 и не должно быть повторений)
    - int year (>1900)
    - String author (>2 && <30)
    - String title  (>2 && <30)

    BookFatalReadException extends Exception

    BookMetaReadException extends RuntimeException

    сделать метод, который будет
    запрашивать с консоли ввод книги
    проверять все введенные данные

    если есть ошибка при чтении id или года выпуска
    должен выбрасывать BookFatalReadException

    если есть ошибка при чтении author или title
    должен выбрасывать BookMetaReadException

    создать объект Library и вызывать в цикле
    ввод нескольких книг
     */

    private void read() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
    }
}
