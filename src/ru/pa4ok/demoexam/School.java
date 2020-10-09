package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.List;

public class School extends Building
{
    private int index;
    private String title;
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public School(String address, int floorCount, int index, String title) {
        super(address, floorCount);
        this.index = index;
        this.title = title;
    }

    public void addEntity(Human human)
    {
        if(human instanceof Teacher) {
            teachers.add((Teacher) human);
        } else if(human instanceof Student) {
            students.add((Student) human);
        } else {
            System.out.println("Not a school entity: " + human);
        }
    }

    @Override
    public String toString() {
        return "School{" +
                "index=" + index +
                ", title='" + title + '\'' +
                ", teachers=" + teachers +
                ", students=" + students +
                ", address='" + address + '\'' +
                ", floorCount=" + floorCount +
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
