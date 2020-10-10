package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.List;

public class School
{
    private int index;
    private String title;
    private List<Teacher> teachers;
    private List<Student> students;

    public School(int index, String title, List<Teacher> teachers, List<Student> students)
    {
        this.index = index;
        this.title = title;
        this.teachers = teachers;
        this.students = students;
    }

    public School(int index, String title)
    {
        this(index, title, new ArrayList<>(), new ArrayList<>());
    }

    @Override
    public String toString() {
        return "School{" +
                "index=" + index +
                ", title='" + title + '\'' +
                ", teachers=" + teachers +
                ", students=" + students +
                '}';
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
