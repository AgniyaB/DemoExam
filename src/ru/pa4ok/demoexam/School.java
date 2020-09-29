package ru.pa4ok.demoexam;

import java.util.Arrays;

public class School
{
    private int index;
    private String name;
    private Teacher[] teachers; //null
    private Student[] students;

    public School(int index, String name, Teacher[] teachers, Student[] students)
    {
        this.index = index;
        this.name = name;
        this.teachers = teachers;
        this.students = students;
    }

    public School(int index, String name) {
        this(index, name, new Teacher[2], new Student[2]);
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
