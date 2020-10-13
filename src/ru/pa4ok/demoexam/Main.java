package ru.pa4ok.demoexam;

public class Main
{
    public static void main(String[] args)
    {

    }

    /*
    EntityLiving
    - String type

    Animal extends EntityLiving
    - boolean canPet
    - boolean hasSound
    - String sound
        если hasSound == false
        тогда поле равно null

    Predator extends Animal
    - super(canPet = false)

    Tiger extends Predator

    Dog extends Animal

    Ant extends Animal

    Bird extends Animal

    Zoo
    - String title
    - List<Animal> animals
    - void getAllSounds()
        должен вывести в консоль
        звуки всех животных
        без повторений
    - List<Predator> getAllPredators
        должен вернуть всех хищников
        с повторениями
     */
}
