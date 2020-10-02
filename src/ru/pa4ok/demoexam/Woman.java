package ru.pa4ok.demoexam;

import ru.pa4ok.demoexam.Human;

public class Woman extends Human
{
    public Woman(String name, int age) {
        super(name, age, true);
    }

    @Override
    public String toString() {
        return "Woman{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isWomen=" + isWomen +
                '}';
    }
}
