package ru.pa4ok.demoexam.shool;

import java.util.Arrays;

public class School
{
    private static int INDEX_COUNTER = 0;

    private final int index;
    private String name;
    private Teacher[] teachers;
    private Student[] students;

    public School(String name, Teacher[] teachers, Student[] students) {
        this.index = ++INDEX_COUNTER;
        this.name = name;
        this.teachers = teachers;
        this.students = students;
    }

    public School(String name) {
        this(name, new Teacher[2], new Student[2]);
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
