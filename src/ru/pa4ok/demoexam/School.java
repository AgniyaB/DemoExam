package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.List;

public class School
{
    private int index;
    private String title;
    private List<Teacher> teacherList;
    private List<Student> studentList;

    public School(int index, String title, List<Teacher> teacherList, List<Student> studentList)
    {
        this.index = index;
        this.title = title;
        this.teacherList = teacherList;
        this.studentList = studentList;
    }

    public School(int index, String title) {
        this(index, title, new ArrayList<>(), new ArrayList<>());
    }

    @Override
    public String toString() {
        return "School{" +
                "index=" + index +
                ", title='" + title + '\'' +
                ", teacherList=" + teacherList +
                ", studentList=" + studentList +
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

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
