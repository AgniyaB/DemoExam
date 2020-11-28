package ru.pa4ok.appname;

public class Person
{
    private int id;
    private String firstname;
    private String surname;
    private int age;
    private Passport passport;

    public Person(int id, String firstname, String surname, int age, Passport passport) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.age = age;
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", passport=" + passport +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
