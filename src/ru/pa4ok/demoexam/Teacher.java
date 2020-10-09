package ru.pa4ok.demoexam;

public class Teacher extends Human
{
    private String subject;

    public Teacher(String name, int age, boolean isWoman, String subject) {
        super(name, age, isWoman);
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + subject + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isWoman=" + isWoman +
                '}';
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
