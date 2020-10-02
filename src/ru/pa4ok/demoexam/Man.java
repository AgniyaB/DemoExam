package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.Human;

public class Man extends Human
{
    public Man(String name, int age) {
        super(name, age, false);
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isWomen=" + isWomen +
                '}';
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\n" + "Gender: man";
    }
}
