package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.List;

public class Zoo
{
    private String title;
    private List<Animal> animals = new ArrayList<>();

    public Zoo(String title) {
        this.title = title;
    }

    public void getAllSounds()
    {
        List<String> list = new ArrayList<>();
        for(Animal a : animals) {
            if(a.hasSound && !list.contains(a.getSound())) {
                list.add(a.getSound());
            }
        }
        System.out.println(list);
    }

    public List<Predator> getAllPredators()
    {
        List<Predator> list = new ArrayList<>();
        for(Animal a : animals) {
            if(a instanceof Predator) {
                list.add((Predator) a);
            }
        }
        return list;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "title='" + title + '\'' +
                ", animals=" + animals +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
