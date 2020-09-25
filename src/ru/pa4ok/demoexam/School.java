package ru.pa4ok.demoexam;

import java.util.Arrays;

public class School
{
    private int number;
    private String name;
    private Teacher[] teachers = new Teacher[1];
    private Student[] students = new Student[2];

    public School(int number, String name, Teacher[] teachers, Student[] students)
    {
        this.number = number;
        this.name = name;
        this.teachers = teachers;
        this.students = students;
    }

    public School(int number, String name)
    {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return "School{" +
                "number=" + number +
                ", name='" + name + '\'' +
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
