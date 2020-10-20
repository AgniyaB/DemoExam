package ru.pa4ok.demoexam;

public class NewMain
{
    public static void main(String[] args)
    {
        //нельзя напрямую создать объект абстрактного класса
        //EntityLiving e = new EntityLiving();


       /* Dog dog = new Dog();
        System.out.println(dog.getSound());*/

        EntityLiving entity = new Dog();

        if(entity instanceof Dog)
        {
            Dog dog = (Dog)entity;
            System.out.println(dog.getSound());
        }

        //System.out.println(e instanceof ISoundEntity);
        if(entity instanceof ISoundEntity)
        {
            ISoundEntity soundEntity = (ISoundEntity)entity;
            System.out.println(soundEntity.getSound());
        }
    }

    /*
    abstract Animal
    - String type
    - int legCount

    interface ISoundEntity
    - String getSound()

    interface IFlyEntity
    - int getMaxFlyHeight()

    Dog extends Animal implements ISoundEntity
    - String name
    - String getSound()

    Ant extends Animal

    FlyingAnt extends Ant implements IFlyEntity
    - int getMaxFlyHeight()

    Pigeon extends Animal implements IFlyEntity, ISoundEntity
    - int getMaxFlyHeight()
    - String getSound()

    Zoo
    - String title
    - List<Animal> animals
    - [метод] List<IFlyEntity> getAllFlyEntities()
        создаеь List<IFlyEntity>
        проверяет всех животных
        если подходят - добавляет с приведением типов
    - [метод] void printAllSounds()
        выводит звуки всех животных
        без повторений
     */
}
