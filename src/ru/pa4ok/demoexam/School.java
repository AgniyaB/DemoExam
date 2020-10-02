package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.List;

public class School extends Building
{
    private int index;
    private String name;
    private List<Teacher> teachers;
    private List<Student> students;

    public School(String adress, int flootCount, int index, String name, List<Teacher> teachers, List<Student> students) {
        super(adress, flootCount);
        this.index = index;
        this.name = name;
        this.teachers = new ArrayList<>(teachers);
        this.students = new ArrayList<>(students);
    }

    public School(String adress, int flootCount, int index, String name) {
        this(adress, flootCount, index, name, new ArrayList<>(), new ArrayList<>());
    }

    @Override
    public String toString() {
        return "School{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", teachers=" + teachers +
                ", students=" + students +
                ", adress='" + adress + '\'' +
                ", flootCount=" + flootCount +
                '}';
    }

    public void addEntity(Human human) {
        if(human instanceof Teacher) {
            teachers.add((Teacher)human);
        } else if(human instanceof Student) {
            students.add((Student)human);
        } else {
            System.out.println("Not a school entry: " + human);
        }
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
