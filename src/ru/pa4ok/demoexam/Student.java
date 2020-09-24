package ru.pa4ok.demoexam;

public final class Student
{
    public static final String CITY = "SPB";

    public int id;
    protected String name;
    private String surname;
    //String test; //private

    public Student(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Student(String name, String surname) {
        this(-1, name, surname);
    }

    public Student() {}

    public static void staticTest()
    {
        System.out.println("static test");
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public void test1() {}

    protected final void test2() {}

    protected void test3() {}

    private void test4() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
