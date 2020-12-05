package ru.pa4ok.appname;

import java.util.ArrayList;
import java.util.List;

public class School
{
    private int index;
    private String title;
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public School(int index, String title) {
        this.index = index;
        this.title = title;
    }

    public void addEntity(Human hunan)
    {
        if(hunan instanceof Student) {
            students.add((Student) hunan);
            System.out.println("Это студент: " + hunan);
        } else if(hunan instanceof Teacher) {
            teachers.add((Teacher) hunan);
            System.out.println("Это преподаватель: " + hunan);
        } else {
            System.out.println("Это левый чел: " + hunan);
        }
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
