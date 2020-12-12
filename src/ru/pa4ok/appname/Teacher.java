package ru.pa4ok.appname;

public class Teacher extends Human
{
    private String subject;
    private int exp;

    public Teacher(String firstname, String surname, boolean isWoman, int age, String subject, int exp) {
        super(firstname, surname, isWoman, age);
        this.subject = subject;
        this.exp = exp;
    }

    @Override
    public void work()
    {
        System.out.println("work from Teacher");
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + subject + '\'' +
                ", exp=" + exp +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", isWoman=" + isWoman +
                ", age=" + age +
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
