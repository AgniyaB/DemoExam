package ru.pa4ok.appname;

import java.util.Arrays;

public class School
{
    private int number;
    private String title;
    private Teacher[] teachers;
    private Student[] students;

    public School(int number, String title, Teacher[] teachers, Student[] students) {
        this.number = number;
        this.title = title;
        this.teachers = teachers;
        this.students = students;
    }

    public School(int number, String title) {
        this.number = number;
        this.title = title;
        teachers = new Teacher[2];
        students = new Student[2];
    }

    @Override
    public String toString() {
        return "School{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", teachers=" + Arrays.toString(teachers) +
                ", students=" + Arrays.toString(students) +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

