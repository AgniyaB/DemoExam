package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Tiger());
        animals.add(new Ant());
        animals.add(new Bird());

        doAllSounds(animals);
    }

    private static void doAllSounds(List<Animal> animals) {
        for(Animal a : animals)
        {
            String str = a.toString();
            if(a instanceof ISoundEntity) {
                str += " | sound: ";
                str += ((ISoundEntity)a).getSound();
            }
            if(a instanceof IFlyAnimal) {
                str += " | max fly height: ";
                str += ((IFlyAnimal)a).getMaxFlyHeight();
            }
            System.out.println(str);
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
