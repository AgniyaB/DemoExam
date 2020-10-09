package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main
{
    public static final String SPB = "SPB";

    public static void main(String[] args)
    {
        /*List<Book> books = new ArrayList<>();

        for(int i=0; i<10; i++) {
            books.add(new Book("title-" + i, "author-" + i, BookStatusEnum.IN_LIBRARY));
        }
        Collections.shuffle(books); //рандомный порядок элементов списка

        *//*for(int i=0; i<books.size(); i++) {
            for(int j=0; j<books.size()-1; j++) {
                //пузырек это классно
            }
        }*//*

        //вариант 1
        *//*Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                //-1 - o1<o2
                //0 - o1==o2
                //1 - o1>o2
                return Long.compare(o1.getId(), o2.getId());
            }
        });*//*

        //вариант 2 (см. также implements Comparable в Book)
        Collections.sort(books);

        System.out.println(books);*/

       /* Human human = new Human("vasya", 15, GenderEnum.MALE);
        if(human.getGender() == GenderEnum.MALE) {
            System.out.println("mark13567457654");
        }*/
    }
}
