package ru.pa4ok.demoexam.sorts;

import ru.pa4ok.demoexam.maps.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortMain
{
    public static void main(String[] args)
    {
        List<Book> list = new ArrayList<>();
        for(int i=0; i<10; i++) {
            list.add(new Book("title" + i, "autor" + i));
        }
        Collections.shuffle(list); //перемешивает

        Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) { //-1 a<b // 0 a==b // 1 a>b
                /*if(o1.getId() < o2.getId()) {
                    return -1;
                }*/
                //return Integer.compare(o1.getId(), o2.getId());

                //по алфавиту
                return String.CASE_INSENSITIVE_ORDER.compare(o1.getTitle(), o2.getTitle());
            }
        });

        System.out.println(list);
    }
}
