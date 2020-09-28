package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        /*List<String> list = new ArrayList<>();
        list.add("string 1");
        list.add("string 2");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(0));
        //list.remove(1); //удаление по индексу
        System.out.println(list);
        //list.remove("string 1"); //удаление по объекту
        //list.clear();
        System.out.println(list.contains("dsflbwdf"));
        System.out.println(list.contains("string 1"));
        System.out.println(list.indexOf("string 2"));
        //list.isEmpty(); //всместо list.size() == 0
        list.set(0, "new string");
        System.out.println(list);
        list.add("234324324");
        list.add("34;gmgrereg");
        System.out.println(list);
        System.out.println(list.subList(1, 3));*/

        /*List<Student> list = new ArrayList<>();
        list.add(new Student("Vasya", 5));
        System.out.println(list);*/

        /*Student student = new Student("Vasya", 5);
        student.getStrings().add("32424");*/

        /*List<String> list = Arrays.asList("324234", "354354", "534534");
        System.out.println(list);*/
    }

    private static <T> List<T> asList(T... objs)
    {
        List<T> list = new ArrayList<>();
        for(T t : objs) {
            list.add(t);
        }
        return list;
    }
}

