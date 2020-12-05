package ru.pa4ok.appname;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    /*
    Student
    - String surname
    - String firstname
    - int level //класс

    Teacher
    - String surname
    - String firstname
    - int exp //стаж

    School
    - int number
    - String title
    - List<Teacher> teachers
    - List<Student> students

    у всех классов переопределен метод toString()
    все поля приватные + геттеры и сеттеры
    создать объект школы со студертами и учителями
    вывести его в консоль
     */

    public static void main(String[] args)
    {
        //List<int> нельзя, List<Integer> можно
        List<String> list = new ArrayList<>();

        String s = "second";

        list.add("first");
        list.add(s);
        list.add("third");

        //System.out.println(list.get(1));

        /*System.out.println(list);
        list.remove(s); //удаление по объекту
        System.out.println(list);
        list.remove(1); //удаление по индексу
        System.out.println(list);*/

        /*int size = list.size();
        String first = list.get(0);
        boolean isEmpty = list.isEmpty();
        list.clear();*/

        //System.out.println(list.contains(s));
        //System.out.println(list.contains("eiofhowefh"));




        /*TestClass test = new TestClass();
        test.getStrings().add("eoffewfewjofe");
        test.getStrings().add("ijfofejwfqew");
        System.out.println(test);
        */

        /*TestClass test = new TestClass(list);
        System.out.println(test);
        test.getStrings().clear();
        System.out.println(test);*/

        /*
        Если у Вас стоит java >= 9 тогда спокойно используйте List.of("woidhwd", "oewhfewf")

        Если стоит 8 java есть Arrays.asList("woidhwd", "oewhfewf")
        но есть ограничение, данная функция возвращает список который нельзя изменять
        это можно обойти через пересоздание списка
        new ArrayList<>(Arrays.asList("ofjfei", "oewfjoifew", "oefefwew"))
         */
        TestClass test = new TestClass(
                new ArrayList<>(Arrays.asList("ofjfei", "oewfjoifew", "oefefwew"))
        );
        System.out.println(test);
        test.getStrings().add("eofkewffe");
        System.out.println(test);
    }
}

class TestClass
{
    //private List<String> strings = new ArrayList<>();
    private List<String> strings;

    public TestClass(List<String> strings) {
        this.strings = strings;
    }

    public TestClass() {
        this(new ArrayList<>());
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "strings=" + strings +
                '}';
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }
}
