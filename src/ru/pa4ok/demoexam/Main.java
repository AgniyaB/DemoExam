package ru.pa4ok.demoexam;

public class Main
{
    public static void main(String[] args)
    {
        Dog dog = new Dog("rewfwer", 4);
        Ant ant = new Ant("efef", 1);
        Bird bird1 = new Bird("bird", 2);
        Bird bird2 = new Bird("bird", 3);

        Zoo zoo = new Zoo("zoo");
        zoo.getAnimals().add(dog);
        zoo.getAnimals().add(ant);
        zoo.getAnimals().add(bird1);
        zoo.getAnimals().add(bird2);

        System.out.println(zoo.getAllFlyAnimals());
        System.out.println();
        zoo.printAllSounds();
    }


    /*
    abstract EntityLiving
    - String type
    - int age

    interface ISoundEntity
    - String getSound()

    interface IFlyEntity
    - double getMaxFlyHeight()
    - int getMaxFlyTime()

    //
    2-3 класса животных, которые
    наследуют EntityLiving и реализуют
    ISoundEntity и/или IFlyEntity
    //

    Zoo
    - String title
    - List<EntityLiving> animals
    - List<IFlyEntity> getAllFlyAnimals()
        //функция должна вернуть List<IFlyEntity>
        //те список всех летающих животных в зоопарке
    - void printAllSounds()
        //вывести звуки всех животных
        //без повторений
     */
}
