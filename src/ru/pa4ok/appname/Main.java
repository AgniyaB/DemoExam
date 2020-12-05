package ru.pa4ok.appname;

import java.util.Arrays;

public class Main
{
    /*
    Page
    - int number
    - String[] words

    Chapter
    - int number
    - String title
    - Page[] pages

    Book
    - String title
    - String author
    - Chapter[] chapters

    у всех классов переопределен метод toString()
    все поля приватные + геттеры и сеттеры
    создать объект книги с парой глав с парой слов в каждой
    вывести его в консоль
     */

    public static void main(String[] args)
    {
        /*Book voinaImir = new Book(
                "война и мир",
                "пушкин",
                new Chapter[]{
                        new Chapter(
                                1,
                                "глава 1",
                                new Page[]{
                                        new Page(
                                                1,
                                                new String[] {
                                                    "wor[wkdqw", "oefjoief", "oewfhoqhwdq"
                                                }
                                        ),
                                        new Page(
                                                2,
                                                new String[] {
                                                        "wor[wkdqw", "oefjoief", "oewfhoqhwdq"
                                                }
                                        )
                                }
                        ),
                        new Chapter(
                                1,
                                "глава 2",
                                new Page[]{
                                        new Page(
                                                3,
                                                new String[] {
                                                        "wor[wkdqw", "oefjoief", "oewfhoqhwdq"
                                                }
                                        ),
                                        new Page(
                                                4,
                                                new String[] {
                                                        "wor[wkdqw", "oefjoief", "oewfhoqhwdq"
                                                }
                                        )
                                }
                        )
                }
        );*/

        Book voinaImir = new Book("война и мир", "пушкин");

        System.out.println(voinaImir);

        voinaImir.getChapters()[0] = new Chapter(1, "глава 1 ,война");
        voinaImir.getChapters()[1] = new Chapter(2, "глава 2, мир");

        System.out.println(voinaImir);
    }
}
