package ru.pa4ok.demoexam;

//нельзя напрямую создать объект
public abstract class EntityLiving
{
    protected String type;
    protected int age;

    public EntityLiving(String type, int age) {
        this.type = type;
        this.age = age;
    }

    /*//у функции нет тела, грубо говоря заготовка
    public abstract String getSound();*/

    @Override
    public String toString() {
        return "EntityLiving{" +
                "type='" + type + '\'' +
                ", age=" + age +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
