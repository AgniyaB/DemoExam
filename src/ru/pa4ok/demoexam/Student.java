package ru.pa4ok.demoexam;

//класс Student наследует класс Human
public class Student extends Human
{
    protected int schoolId;
    protected int level;

    public Student(String name, int age, boolean isWomen, int schoolId, int level)
    {
        super(name, age, isWomen); //вызов родительского конструктора

        this.schoolId = schoolId;
        this.level = level;
    }

    /*@Override
    public void test()
    {
        //если класс наследник расширяет а
        //не перезаписывает полностью методы
        //есть возможность вызвать метод из класса родитеоя
        super.test();
        System.out.println("Student test");
    }*/

    @Override
    public String toString() {
        return "Student{" +
                "schoolId=" + schoolId +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isWomen=" + isWomen +
                '}';
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
