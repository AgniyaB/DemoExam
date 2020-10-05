package ru.pa4ok.demoexam.task;

import java.util.ArrayList;
import java.util.List;

public class School extends Building
{
    private int index;
    private String name;
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public School(String adress, int floorCount, int index, String name) {
        super(adress, floorCount);
        this.index = index;
        this.name = name;
    }

    public void addEntity(Human human)
    {
        if(human instanceof Teacher) {
            teachers.add((Teacher)human);
        } else if(human instanceof Student) {
            students.add((Student)human);
        } else {
            System.out.println("Ему нечего тут делать " + human);
        }
    }

    @Override
    public String toString() {
        return "School{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", teachers=" + teachers +
                ", students=" + students +
                ", adress='" + adress + '\'' +
                ", floorCount=" + floorCount +
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
