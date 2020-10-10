package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();

        list.add("erwgowewe");
        list.add("42243");
        list.add("4344gergrge");

        //list.size();
        //list.isEmpty();
        //list.clear();

        //System.out.println(list.get(2));
        //list.set(2, "new String");
        //System.out.println(list.get(2));

        /*System.out.println(list);
        list.remove(0); //удаление по индексу
        list.remove("4344gergrge"); //удаление по объекту*/

        System.out.println(list);

        //System.out.println(list.contains("4344gergrge"));
        //System.out.println(list.contains("....efwef"));


        //List<String> list1 = Arrays.asList("1", "2", "3"); //тут нельзя будет изменять список
        List<String> list1 = new ArrayList<>(Arrays.asList("1", "2", "3")); //тут уже фикс
        //java 9+ List.of(...)
        System.out.println(list1);
        //list1.add("4"); Arrays.asList возвращает реализацию List без части методов

        for(String s : list) {
            System.out.printf(s + " ");
        }
        System.out.println();

        for(int i=0; i<list.size(); i++)
        {
            String s = list.get(i);
            System.out.printf(s + " ");
        }
        System.out.println();
    }

    /*
    все поля приватные
    + геттеры и сеттеры

    Student
    - String name
    - int level
    - toString()

    Teacher
    - String name
    - String subject
    - toString()

    School
    - int index
    - String name
    - List<Teacher> teachers
    - List<Student> students
    - toString()
     */
}

class School
{
    //private List<String> list = ArrayList<>();

    /*private List<String> list;

    public School(List<String> list) {
        this.list = new ArrayList<>(list);
    }*/
}
