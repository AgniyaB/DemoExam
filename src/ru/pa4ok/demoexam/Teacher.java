package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Human
{
    protected String subject;

    public Teacher(String name, int age, boolean isWomen, String subject) {
        super(name, age, isWomen);
        this.subject = subject;
    }

    /*@Override
    public void work()
    {
        super.work();
        System.out.println("work from Teacher.class");
    }*/

    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + subject + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isWomen=" + isWomen +
                '}';
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
