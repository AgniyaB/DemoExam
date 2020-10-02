package ru.pa4ok.demoexam.shool;

//final для класса = нельзя унаследовать
public final class Student
{
    public static final String CITY = "SPB";

    //private final String name; //объявляется 1 раз, либо сразу, либо во всех конструкторах
    private String name;
    private int age;
    private int level;

    public Student(String name, int age, int level) {
        this.name = name;
        this.age = age;
        this.level = level;
    }

    //final для метода = нельзя переопределить в классе наследнике
    public final void test() {
        testStatic();
    }

    public static void testStatic() {
        System.out.println("test static");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", level=" + level +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
