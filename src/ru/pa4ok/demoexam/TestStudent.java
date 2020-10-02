package ru.pa4ok.demoexam;

public class TestStudent
{
    //только из этого файла
    private String name;
    //везде
    public int age;
    //из одного пакета или классов наследников
    protected int level;

    public TestStudent(String name, int age, int level) {
        this.name = name;
        this.age = age;
        this.level = level;
    }

    public TestStudent(String name, int age)
    {
        //вызов 1 конструктора из 2
        this(name, age, 1);
    }

    //@Override //указывает на то что метод переопределен
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
