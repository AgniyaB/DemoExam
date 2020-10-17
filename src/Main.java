public class Main
{
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
    - [функция] List<IFlyEntity> getAllFlyAnimals()
        //возвращает список с всеми IFlyEntity из animals
    - void playAllAnimalSounds()
        //выводит все звуки животных, без повторений
     */

    public static void main(String[] args)
    {
        Zoo zoo = new Zoo("peso4naya 14");
        zoo.getAnimals().add(new Ant());
        zoo.getAnimals().add(new Bird());
        zoo.getAnimals().add(new Bird());
        zoo.getAnimals().add(new Bird());
        zoo.getAnimals().add(new Microbe(true));
        zoo.getAnimals().add(new Microbe(false));
        zoo.getAnimals().add(new Tiger());
        zoo.getAnimals().add(new Tiger());

        System.out.println(zoo.getAllFlyEntities());
        System.out.println();
        zoo.playAllAnimalSounds();

    }
}
