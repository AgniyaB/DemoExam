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
        //нельзя просто так создать объект абстрактного класса
        //EntityLiving e = new EntityLiving();

        //мы можем унаследовать абстрактный класс и создать объект
        //Animal a = new Animal("млекопитающее");
        //Microbe m = new Microbe();

        /*System.out.println(a);
        System.out.println(m);
        System.out.println();
        a.test();
        m.test();*/

        //EntityLiving e = new Animal("млекопитающее");

        Animal a = new Tiger();
        Animal b = new Ant();

        //System.out.println(a instanceof ISoundEntity);
        //System.out.println(b instanceof ISoundEntity);


        printSound(a);
        printSound(b);

    }

    private static void printSound(Animal animal)
    {
        if(animal instanceof ISoundEntity) {
            System.out.println(((ISoundEntity)animal).getSound());
        } else {
            System.out.println("no sound");
        }
    }
}
