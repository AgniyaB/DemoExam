package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.List;

public class School extends Building
{
    private int index;
    private String name;
    private SchoolTypeEnum schoolType;
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public School(String address, int floorCount, int index, String name, SchoolTypeEnum schoolType) {
        super(address, floorCount, BuildingTypeEnum.SOCIAL);
        this.index = index;
        this.name = name;
        this.schoolType = schoolType;
    }

    @Override
    public String toString() {
        return "School{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", schoolType=" + schoolType +
                ", teachers=" + teachers +
                ", students=" + students +
                ", address='" + address + '\'' +
                ", floorCount=" + floorCount +
                ", buildingType=" + buildingType +
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

    public SchoolTypeEnum getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(SchoolTypeEnum schoolType) {
        this.schoolType = schoolType;
    }
}
