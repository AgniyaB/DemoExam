package ru.pa4ok.demoexam;

public class Main
{
    public static void main(String[] args)
    {
        Zoo zoo = new Zoo("zoo");
        zoo.getAnimals().add(new Tiger());
        zoo.getAnimals().add(new Tiger());
        zoo.getAnimals().add(new Bird());
        zoo.getAnimals().add(new Ant());

        System.out.println(zoo.getAllFlyEntities());
        zoo.playAllAnimalSounds();
    }

    /*
    все поля в наследуемых классах protected
    остальные поля private + геттеры и сеттеры
    во всех классах toString()

    abstract EntityLiving
    - abstract String getType()
    - abstract boolean canPet()

    interface ISoundEntity
    - String getSound()

    interface IFlyEntity
    - int getMaxFlyTime()
    - double getMaxFlyHeight()

    //
    3-4 класса животных
    которые реализурую разные итерефейсы (или нет)
    //

    Zoo
    - String address
    - List<EntityLiving> animals
    - List<IFlyEntity> getAllFlyAnimals()
        //возвращает список с всеми IFlyEntity из animals
    - void playAllAnimalSounds()
        //выводит все звуки животных, без повторений
     */
}
