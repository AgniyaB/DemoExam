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

    public List<IFlyEntity> getAllFlyEntities()
    {
        List<IFlyEntity> list = new ArrayList<>();
        for(EntityLiving e : animals) {
            if(e instanceof IFlyEntity) {
                list.add((IFlyEntity)e);
            }
        }
        return list;
    }

    public void playAllAnimalSounds()
    {
        List<String> list = new ArrayList<>();
        for(EntityLiving e : animals) {
            if(e instanceof ISoundEntity) {
                ISoundEntity iSoundEntity = (ISoundEntity)e;
                if(!list.contains(iSoundEntity.getSound())) {
                    list.add(iSoundEntity.getSound());
                }
            }
        }

        System.out.println(list);
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
