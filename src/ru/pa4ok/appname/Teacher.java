package ru.pa4ok.appname;

public class Teacher
{
    private String firstname;
    private String surname;
    private String subject;
    private int exp;

    public Teacher(String firstname, String surname, String subject, int exp) {
        this.firstname = firstname;
        this.surname = surname;
        this.subject = subject;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", subject='" + subject + '\'' +
                ", exp=" + exp +
                '}';
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
