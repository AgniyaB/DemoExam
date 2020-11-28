package ru.pa4ok.appname;

public class School
{
    private int number;
    private String title;
    private Teacher teacher;
    private Student student;

    public School(int number, String title, Teacher teacher, Student student) {
        this.number = number;
        this.title = title;
        this.teacher = teacher;
        this.student = student;
    }

    @Override
    public String toString() {
        return "School{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", teacher=" + teacher +
                ", student=" + student +
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

