package ru.pa4ok.demoexam.school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class School
{
    private int index;
    private String name;
    private Teacher[] teachers;
    private Student[] students;

    //private List<Teacher> teachers = new ArrayList<>();
    //school.getTeachers().add(new Teacher(...))

    /*private List<Teacher> teachers;
    public School(List<Teacher> teachers) {
        this.teachers = teachers;
    }
    List<String> list = Arrays.asList("452", "5435", "54");*/

    public School(int index, String name, Teacher[] teachers, Student[] students) {
        this.index = index;
        this.name = name;
        this.teachers = teachers;
        this.students = students;
    }

    @Override
    public String toString() {
        return "School{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", teachers=" + Arrays.toString(teachers) +
                ", students=" + Arrays.toString(students) +
                '}';
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
