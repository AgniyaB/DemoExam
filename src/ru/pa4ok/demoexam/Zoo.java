package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.List;

public class Zoo
{
    private String title;
    private List<EntityLiving> animals = new ArrayList<>();

    public Zoo(String title) {
        this.title = title;
    }

    public List<IFlyEntity> getAllFlyAnimals(){
        List<IFlyEntity> list = new ArrayList<>();
        for(EntityLiving e : animals) {
            if(e instanceof IFlyEntity) {
                list.add((IFlyEntity) e);
            }
        }
        return list;
    }

    public void printAllSounds()
    {
        List<String> list = new ArrayList<>();
        for(EntityLiving e : animals) {
            if(e instanceof ISoundEntity) {
                ISoundEntity soundEntity = (ISoundEntity)e;
                if(!list.contains(soundEntity.getSound())) {
                    list.add(soundEntity.getSound());
                }
            }
        }
        System.out.println(list);

        //вариант 2 с использованием Set (элементы повторяются только 1 раз)
        /*Set<String> set = new HashSet<>();
        for(EntityLiving e : animals) {
            if(e instanceof ISoundEntity) {
                set.add(((ISoundEntity)e).getSound());
            }
        }
        System.out.println(set);*/
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

    public List<EntityLiving> getAnimals() {
        return animals;
    }

    public void setAnimals(List<EntityLiving> animals) {
        this.animals = animals;
    }
}
