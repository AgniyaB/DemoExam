package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.school.Student;

import java.util.*;

public class Lists
{
    public static void main(String[] args)
    {
         /*List<String> list = new ArrayList<>();
         //List<int> // нельзя использовать примитивы
         //List<Integer>

        list.add("olrghrwergwer");
        list.add("344334324");
        list.add("4234KLGHF");
        System.out.println(list);
        list.remove("344334324");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);*/

        /*list.size();
        String s = list.get(0);
        list.set(1, s);
        list.clear();
        boolean hasListElemnt = list.contains(s);
        list.isEmpty();*/

        //Arrays.asList()

        Map<Integer, Miner> map = new HashMap<>();
        //<ключ, значение>
        //если отправить значение с таким же ключем, то старое перезапишется
        //порядок добавления != порядку хранения

        Miner s1 = new Miner(1, "Vasya", 4);
        Miner s2 = new Miner(2, "Petya", 3);

        map.put(s1.getId(), s1);
        map.put(s2.getId(), s2);

        /*System.out.println(map);
        System.out.println(map.get("Petya"));
        System.out.println(map.get("Kolya"));*/

        //map.clear();
        //map.isEmpty();

        /*for(String s : map.keySet()) {
            System.out.printf(s + " ");
        }
        System.out.println("\n\n");

        for(Miner s :map.values()) {
            System.out.println(s);
        }

        for(Map.Entry<Integer, Miner> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + "_" + entry.getValue());
        }*/

        //System.out.println(map.get(1));

        System.out.println(map);
        map.remove(2); //ключ
        System.out.println(map);
        map.remove(s1.getId(), s2); //ключ и значение
        System.out.println(map);
        map.remove(s1.getId(), s1);
        System.out.println(map);
    }
}
