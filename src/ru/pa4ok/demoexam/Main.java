package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        /*Cat cat = new Cat();
        Tiger tiger = new Tiger();*/

        /*Animal animalCat = new Cat();
        Tiger tiger = new Tiger();*/

        //приведение типов
        //Cat newCat = (Cat)animalCat;

        //System.out.println(cat);
        //System.out.println(tiger);

        /*List<Animal> animals = new ArrayList<>();
        animals.add(animalCat);
        animals.add(tiger);
        animals.add(new Ant());*/

        //System.out.println(animals);

        /*for(Animal a : animals) {
            if(a instanceof Cat) {
                System.out.println("It's a cat: " + a.toString());
            } else if(a instanceof Tiger) {
                System.out.println("It's a tiger: " + a.toString());
            } else {
                System.out.println("Я не знаю кто это: " + a.toString());
            }
        }*/

        //getAllSounds(animals);

        Cat cat = new Cat();
        cat.updateEntity();
    }

    /*private static void getAllSounds(List<Animal> animals)
    {
        for(Animal a : animals)
        {
            String sound = a.getSound();
            if(sound == null) {
                System.out.println("Я не могу издавать звук (" + a.toString() + ")");
            } else {
                System.out.println("Мой звук " + sound + " (" + a.toString() + ")");
            }
        }
    }*/

}
