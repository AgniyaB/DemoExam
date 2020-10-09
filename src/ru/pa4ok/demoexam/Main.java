package ru.pa4ok.demoexam;

public class Main
{
    public static void main(String[] args)
    {
        /*//EntityLiving e = new EntityLiving("млекопитающее", 20);
        Dog d = new Dog("млекопитающее", 5);
        System.out.println(d.getSound());

        EntityLiving dog = new EntityLiving("млекопитающее", 5) {
            @Override
            public String getSound() {
                return "гав";
            }
        };
        System.out.println(dog.getSound());*/

        Tiger tiger = new Tiger("млекопитающее", 5);
        //System.out.println(tiger instanceof IFlyEntity);
        //System.out.println(tiger instanceof ISoundEntity);
        Ant ant = new Ant("млекопитающее", 5);

        playSound(tiger);
        playSound(ant);
    }


    private static void playSound(EntityLiving entityLiving)
    {
        if(entityLiving instanceof ISoundEntity) {
            System.out.println(((ISoundEntity)entityLiving).getSound());
        } else {
            System.out.println("нет звука");
        }
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
    - double getMinFlyHeight()
    - dobule getMaxFlyHeight()

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
