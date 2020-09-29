package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lists {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        //list.isEmpty();
        //list.size();
        //list.clear();
        list.add("43242424");
        list.add("fewfewewf");
        list.add("45ggret");

       /* list.remove(0); // удаление по индексу
        System.out.println(list);
        list.remove("45ggret"); // удаление по объекту*/

        /*List<Integer> integers = new ArrayList<>();
        int i1 = 1;
        Integer i2 = 1;
        integers.remove(i1);
        integers.remove(i2);*/

        //System.out.println(list.get(1));
        //System.out.println(list.contains("kilyaewf"));
        //System.out.println(list.contains("fewfewewf"));

        //list.set(2, "kolya");

        /*for(String s : list) { //сюда копия приходит
            System.out.printf(s + " ");
        }

        for(int i=0; i<list.size(); i++) {
            String s = list.get(i);
        }*/

        /*String[] arr = {"1", "2", "3"};
        List listFromArr = Arrays.asList(arr);
        System.out.println(listFromArr);*/

        System.out.println(list);
    }

    /*//примерная логика Arrays.asList(...)
    private static <T> List<T> customAsList(T... objects)
    {
        List<T> list = new ArrayList<>();
        for(T t : objects) {
            list.add(t);
        }
        return list;
    }*/
}