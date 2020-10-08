package ru.pa4ok.demoexam;

public class Teacher extends Human
{
    private String subject;
    private int exp;

    public Teacher(String name, int age, boolean isWomen, String subject, int exp) {
        super(name, age, isWomen);
        this.subject = subject;
        this.exp = exp;
    }

    @Override
    public void nextYear() {
        super.nextYear();
        exp++;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + subject + '\'' +
                ", exp=" + exp +
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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
