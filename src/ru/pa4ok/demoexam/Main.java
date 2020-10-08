package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        /*Student[] students = new Student[3];
        students[0] = new Student("vasya", 5);
        System.out.println(Arrays.toString(students));*/

        List<Student> list = new ArrayList<>();

        Student s = new Student("vasya", 5);
        list.add(s);
        list.add(new Student("petya", 7));
        list.add(new Student("igor'", 6));

        //System.out.println(list.get(1));
        //list.isEmpty();
        //System.out.println(list.indexOf(s));
        //list.remove(2); //удаление по индексу
        //list.remove(s); //удаление по объекту

        //list.contains(s);
        //list.clear();
        //list.set(2, s);
        //list.size();

        /*for(Student student : list) {
            student.setLevel(11);
        }*/

        /*for(int i=0; i<list.size(); i++) {
            Student student = list.get(i);
            student.setLevel(10);
        }*/

        System.out.println(list);


        School school = new School();
    }

    /*
      School
        - int number
        - String title
        - List<Teacher> teachers
        - List<Student> students
        - toString()

      Teacher
        - String name
        - String subject
        - toString()

      Student
        - String name
        - int level
        - toString()

     */
}
