package ru.pa4ok.demoexam.maps;

public class Entity
{
    //статическое поле idCounter
    //для генерации id у объектов

    private int id;
    private String name;

    public Entity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

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
}
