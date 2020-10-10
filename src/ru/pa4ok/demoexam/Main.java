package ru.pa4ok.demoexam;

public class Main
{
    public static void main(String[] args)
    {
        Dog dog = new Dog("rewfwer", 4);
        Ant ant = new Ant("efef", 1);

        //dog.writeSound();
        writeSoundIfExist(dog);
        writeSoundIfExist(ant);
    }

    private static void writeSoundIfExist(EntityLiving e)
    {
        if(e instanceof ISoundEntity) {
            ISoundEntity soundEntity = (ISoundEntity)e;
            soundEntity.writeSound();
        } else {
            System.out.println("no sound");
        }
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
