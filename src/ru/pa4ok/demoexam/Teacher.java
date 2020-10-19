package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Human
{
    protected String subject;

    public Teacher(String name, int age, GenderEnum gender, String subject) {
        super(name, age, gender);
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + subject + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
