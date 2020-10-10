package ru.pa4ok.demoexam;

import java.util.HashMap;
import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        Map<Integer, Entity> map = new HashMap<>();

        Entity entity = new Entity(1, "first");
        map.put(1, entity);
        map.put(2, new Entity(2, "second"));

        //по 1 ключу хранится только 1 объект
        //при добавлении по уже существующему ключу - перезапись

        //System.out.println(map.get(2));
        //System.out.println(map.get(10));

        //System.out.println(map);
        //map.remove(2); //удаление по ключу
        //map.remove(1, entity); //удаление по связке ключ-значение

        /*map.clear();
        map.size();
        map.isEmpty();*/

        //перебор значений
        /*for(Entity e : map.values()) {
            System.out.println(e);
        }*/

        //перебор ключей
        /*for(Integer i : map.keySet()) {
            System.out.printf(i + " ");
        }
        System.out.println();*/

        //перебор ключ-значение
        /*for(Map.Entry<Integer, Entity> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }*/

        //System.out.println(map);
    }

    /*
    все поля private
    + геттеры и сеттеры

    Book
    - static int idCounter = 0
    - int id
    - String title
    - String author
    - toString()

    Library
    - String title
    - Map<Integer, Book> books
    - toString()

    создать объект библиотки
    заполнить книгами
    потестировать методы
     */
}

class Entity
{
    public int id;
    public String s;

    public Entity(int id, String s) {
        this.id = id;
        this.s = s;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", s='" + s + '\'' +
                '}';
    }
}

