package ru.pa4ok.appname;

public class Human
{
    protected String firstname;
    protected String surname;
    protected boolean isWoman;
    protected int age;

    public Human(String firstname, String surname, boolean isWoman, int age) {
        this.firstname = firstname;
        this.surname = surname;
        this.isWoman = isWoman;
        this.age = age;
    }

    public void work()
    {
        System.out.println("work from Human");
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", isWoman=" + isWoman +
                ", age=" + age +
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

    public boolean isWoman() {
        return isWoman;
    }

    public void setWoman(boolean woman) {
        isWoman = woman;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
