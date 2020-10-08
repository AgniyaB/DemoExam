package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.List;

public class School
{
    //вариант 1
    //private List<Student> students
    // = new ArrayList<>();

    //вариант 2
    private List<Student> students;

    public School(List<Student> students) {
        this.students = students;
    }

    public School() {
        this(new ArrayList<>());
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
