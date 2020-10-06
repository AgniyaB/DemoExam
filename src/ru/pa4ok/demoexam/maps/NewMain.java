package ru.pa4ok.demoexam.maps;

import java.util.HashMap;
import java.util.Map;

public class NewMain
{
    /*
    все поля приватные
    + геттеры и сеттеры

    Library
    - Map<Integer, Book> books
    - String toString()

    Book
    - static int idCounter
    - int id
    - String title
    - String autor
    - String toString()
     */

    public static void main(String[] args)
    {
        //Map<Integer, Entity> map = new HashMap<>();

        /*Entity e1 = new Entity(1, "name1");
        Entity e2 = new Entity(2, "name2");
        map.put(e1.getId(), e1); //если вы сделаете put() с ключем который уже существует, то его перезапишет
        map.put(e2.getId(), e2);*/

        /*System.out.println(map.get(2));
        System.out.println(map.get(5));*/

        /*for(int i=1; i<11; i++) {
            map.put(i, new Entity(i, "name" + i));
        }*/
        //System.out.println(map);
        //System.out.println();

        /*map.remove(4); //удаление по ключу
        map.remove(5, map.get(5)); //удаление по ключу и значению
        map.remove(6, map.get(7));
        System.out.println(map);*/

        /*for(Entity e : map.values()) { //перебор значений
            System.out.println(e);
        }*/

        /*for(Integer i : map.keySet()) { //перебор ключей
            System.out.printf(i + " ");
        }
        System.out.println();*/

        /*for(Map.Entry<Integer, Entity> entry : map.entrySet()) { //перебор ключей + значений
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }*/

        //System.out.println(map);

        /*Library library = new Library();
        for(int i=0; i<10; i++) {
            Book book = new Book("title" + i, "autor" + i);
            library.getBooks().put(book.getId(), book);
        }
        System.out.println(library);*/
    }
}
