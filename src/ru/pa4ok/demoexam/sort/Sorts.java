package ru.pa4ok.demoexam.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorts
{
    public static void main(String[] args)
    {
        List<Book> list = new ArrayList<>();
        for(int i=0; i<6; i++) {
            list.add(new Book("title-" + i));
        }

        Collections.shuffle(list); //рандомно размешивает элементы
        System.out.println(list);

        //вариант 1
        /*Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                *//*
                -1 a<b
                0 a==b
                1 a>b
                 *//*

                return Integer.compare(o2.getId(), o1.getId());
            }
        });*/

        //вариант 2 + интерфейс Comparable в Book
        Collections.sort(list);

        //Double.compare()
        //...

        System.out.println(list);
    }
}
