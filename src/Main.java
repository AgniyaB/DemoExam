public class Main
{
    public static void main(String[] args)
    {
        //нельзя просто так создать объект абстстрактного класса
        //EntityLiving e = new EntityLiving();

        //можно унаследовать и создать объект
        //Animal animal = new Animal();
        //EntityLiving e = new Animal();

        /*EntityLiving e = new Giraffe();
        System.out.println(e);
        System.out.println(e.getType());*/

        Animal ant = new Ant();
        Animal giraffe = new Giraffe();
        printAnimalSound(ant);
        printAnimalSound(giraffe);

    }

    private static void printAnimalSound(Animal animal)
    {
        if(animal instanceof ISoundEntity) {
            ISoundEntity soundEntity = (ISoundEntity)animal;
            System.out.println(soundEntity.getSound());
        } else {
            System.out.println("no sound: " + animal);
        }
    }

    /*
    abstract EntityLiving
    - static int idCounter
    - int id
    - String name
    - abstract String getType()

    abstract Animal extends EntityLiving
    - boolean catPet

    abstract Predator extends Animal
    - всегда передает в родительский конструктор catPet = false

    interface ISoundEntity
    - String getSound()

    interface IFlyEntity
    - double getMaxFlyHeight()
    - int getMaxFlyTime()

    3-4 класса разных животных
    которые наследуют либо Animal, либо Predator
    и реализуют или нет различные интерфейсы

    Zoo
    - String title
    - List<Animal> animals
    - [метод] List<Predator> getAllPredators()
    - [метод] List<IFlyEntity> getAllFlyAnimals()
    - [метод] void playAllAnimalSounds()
        перебирать всех животных
        и выводить их звуки, если таковые есть
        без повторений
     */
}
