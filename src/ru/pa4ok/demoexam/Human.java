package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.List;

public class Human extends EntityLiving
{
    protected String name;
    protected int age;
    protected boolean isWomen;
    protected List<Animal> pets;

    public Human(String name, int age, boolean isWomen, List<Animal> pets) {
        this.name = name;
        this.age = age;
        this.isWomen = isWomen;
        this.pets = new ArrayList<>(pets);
    }

    public Human(String name, int age, boolean isWomen) {
        this(name, age, isWomen, new ArrayList<>());
    }

    @Override
    public String getType() {
        return "млекопитающее";
    }

    public void addPet(Animal animal)
    {
        if(animal.isPet) {
            pets.add(animal);
            System.out.println("Животное успешно добавлено");
        } else {
            System.out.println("Это животное не является домашним");
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isWomen=" + isWomen +
                ", pets=" + pets +
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

    public boolean isWomen() {
        return isWomen;
    }

    public void setWomen(boolean women) {
        isWomen = women;
    }

    public List<Animal> getPets() {
        return pets;
    }

    public void setPets(List<Animal> pets) {
        this.pets = pets;
    }
}
