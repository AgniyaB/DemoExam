package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.List;

public class Lists
{
    public static void main(String[] args)
    {
        List<Student> students = new ArrayList<>();
        System.out.println(students.isEmpty());

        students.add(new Student("Vasya", 5));
        //System.out.println(students);

        Student student = new Student("Petya", 6);
        students.add(student);

        /*System.out.println(students);

        students.remove(0);
        System.out.println(students);

        students.remove(student);
        System.out.println(students);*/

        for(Student s : students) {
            System.out.println(s);
        }

        //копия
        //List<Student> copy = new ArrayList<>(students);
    }
    /*
    переделать задачу с прошлой пары под листы
     */
}
