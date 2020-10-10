package ru.pa4ok.demoexam;

import java.util.*;

public class Sort
{
    public static void main(String[] args)
    {
        /*List<Entity> list = new ArrayList<>();
        for(int i=1; i<7; i++) {
            list.add(new Entity(i, "title-" + i));
        }
        Collections.shuffle(list); //перемешивание коллекции

        *//*for(int i=0; i<list.size(); i++) {
            for(int j=i+1; j<list.size()-1; j++) {
                //пузырек это круто
            }
        }*//*

        Collections.sort(list, new Comparator<Entity>() {
            @Override
            public int compare(Entity o1, Entity o2) {
                //-1 o1<o2
                //0 o1==o2
                //1 o1>o2
                return Integer.compare(o2.id, o1.id);
            }
        });

        System.out.println(list);*/

        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "title1", new Author(1, "name1", 35.4)));
        books.add(new Book(2, "title2", new Author(2, "name2", 70.1)));
        books.add(new Book(3, "title3", new Author(3, "name3", 0.43545)));
        books.add(new Book(4, "title4", new Author(4, "name4", 23.4324)));
        books.add(new Book(5, "title5", new Author(5, "name5", 13)));

        System.out.println(books);

        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Double.compare(o1.getAuthor().getRating(), o2.getAuthor().getRating());
            }
        });

        System.out.println(books);
    }

    /*
    создать список книг
    перемешать его
    и отсортировать по рейтингу автора

    все поля private
    + геттеры и сеттеры
    + toString()

    Book
    - int id
    - String title
    - Author author

    Author
    - int id
    - String name
    - double rating
     */
}