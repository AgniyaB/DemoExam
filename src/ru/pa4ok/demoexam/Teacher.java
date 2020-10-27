package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.type.GenderEnum;

public class Teacher extends Human
{
    private String subject;
    private int exp;

    public Teacher(String name, int age, GenderEnum gender, String subject, int exp) {
        super(name, age, gender);
        this.subject = subject;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + subject + '\'' +
                ", exp=" + exp +
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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
