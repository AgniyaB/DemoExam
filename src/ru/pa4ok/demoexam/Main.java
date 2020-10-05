package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        /*Human human = new Human("Vasya", 20, false);
        human.addPet(new Cat());
        human.addPet(new Tiger());
        System.out.println(human);*/

        List<Animal> animals = new ArrayList<>();
        animals.add(new Cat());
        animals.add(new Tiger());
        animals.add(new Ant());

        doAllSounds(animals);
    }

    private static void doAllSounds(List<Animal> animals) {
        for(Animal a : animals)
        {
            if(a instanceof ISoundEntity) {
                System.out.println(a + " | sound: " + ((ISoundEntity)a).getSound());
            } else {
                System.out.println(a +  " | no sound :=(");
            }
        }
    }


    //все поля protected + геттеры и сеттеры
    /*abstract EntityLiving
    - abstract String getType()
    - String toString()

    Human extends EntityLiving
    - name
    - age
    - isWomen
    - String getType()
    - List<Animal> pets
    - void addPet(Animal) //проверка animal.isPet == true
    - String toString()

    abstract Animal extends EntityLiving
    - int legsCount;
    - boolean isPet;
    - String toString()

    Cat extends Animal
    - String getType()
    - String getSound()
    - String toString()

    Tiger extends Animal //передаст в родителький конструктор isPet = false
    - String getType()
    - String getSound()
    - String toString()
     */

    //-----------------------------------------------------------

    /*
    abstract EntityLiving
    - abstract String getType()
    - String toString()

    interface ISoundEntity
    - String getSound()

    Cat extends Animal
    - String getType()
    - String toString()

    interface IFlyAnimal
    - int getMaxFlyHeight()

    Tiger extends Animal implements ISoundEntity
    - String getType()
    - String getSound()
    - String toString()

    Bird extends Animal implements ISoundEntity, IFlyAnimal
    - String getType()
    - String getSound()
    - int getMaxFlyHeight()
    - String toString()

    Main
    в главном методе создать List<Animal>
    заполнить разными животными
    и сделать перебор элементов проверяя
    на принадлежность ко всем типам
    выводя об этом информацию
     */
}
