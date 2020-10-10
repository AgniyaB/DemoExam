package ru.pa4ok.demoexam.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NewMain
{
    public static void main(String[] args)
    {
        List<Book> books = new ArrayList<>();
        for(int i=0; i<5; i++) {
            books.add(new Book("title-" + i, "author-" + i));
        }
        Collections.shuffle(books); //перемешивание листа

        /*for(int i=0; i<books.size(); i++) {
            for(int j=i+1; j<books.size()-1; j++) {
                //пузырек это круто
            }
        }*/

        /*//вариант 1
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                //-1 o1<o2
                //0 o1==o2
                //1 o1>o2
                return Long.compare(o1.getId(), o2.getId());
                //Integer.compare(...)
                //...
            }
        });*/

        //вариант 2 (см. также compareTo в Book)
        Collections.sort(books);

        System.out.println(books);
    }
}
