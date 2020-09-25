package ru.pa4ok.demoexam;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        /*int[] intArr = new int[10];
        intArr = new int[100];

        List<Integer> list = new ArrayList<>();

        Random rand = new Random();
        for(int i=0; i<12; i++) {
            list.add(rand.nextInt(10000));
        }
        list.add(1337);
        System.out.println(list);

        System.out.println(list.contains(1337));*/

        Student student1 = new Student(1, "Vasya");
        Student student2 = new Student(2, "Petya");
        Student student3 = new Student(3, "Kolya");

        /*List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);*/

        /*System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.contains(student2));
        list.remove(student2);
        System.out.println(list);
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        list.clear();
        System.out.println(list.isEmpty());*/

        /*for(Student s : list) {
            System.out.println(s);
        }*/

        /*Student[] students = new Student[3];
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;

        List<Student> list = Arrays.asList(students);
        Student[] newStudents = (Student[])list.toArray();*/

        /*Map<Integer, Student> map = new HashMap<>();
        map.put(student1.getId(), student1);
        map.put(student2.getId(), student2);
        map.put(student3.getId(), student3);

        System.out.println(map.containsKey(3));
        System.out.println(map.containsKey(4));
        System.out.println(map.containsValue(student2));
        System.out.println(map.containsValue(new Student(5, "Anton")));

        System.out.println(map);
        for(Student s : map.values()) {
            System.out.println(s);
        }
        List<Student> list = new ArrayList<>(map.values());
        System.out.println(list);*/

        //во 2 листе будут скопированные значения, которые можно менять
        //List<Student> list1 = new ArrayList<>();
        //List<Student> list2 = new ArrayList<>(list1);
    }

    /*
    Создать класс описывающий предмет (Subject)
    id, название, имя преподавателя, List<Integer> с оценками, переопределить вывод, геттеры, сеттеры
    Добавить поле List<Subject> в поле студента
     */
}
