package ru.pa4ok.appname.intrf.task;

import java.util.ArrayList;
import java.util.List;

public class NewMan
{
    /*
    abstract EntityLiving
    - int age
    - abstract String getType()

    interface ISoundEntity
    - String getSound()

    interface IFlyEntity
    - int getMaxFlyHeight()
    - int getMaxFlyTime()

    Ant extends EntityLiving

    Tiger extends EntityLiving implements ISoundEntity

    Pigeon extends EntityLiving implements ISoundEntity, IFlyAnimal

    Main
    в главном методе создать List<EntityLiving>
    заполнить разными животными
    и сделать перебор элементов проверяя на принадлежность к разным интерфейсам
    выводя соответствующую информацию
    */

    public static void main(String[] args)
    {
        List<EntityLiving> animals = new ArrayList<>();

        animals.add(new Pigeon(1));
        animals.add(new Tiger(10));
        animals.add(new Pigeon(2));
        animals.add(new Ant(1));
        animals.add(new Tiger(5));
        animals.add(new Tiger(3));
        animals.add(new Ant(1));

        for(EntityLiving e : animals) {
            System.out.println(e);
            if(e instanceof ISoundEntity) {
                System.out.println("Умеет издавать звуки: " + ((ISoundEntity)e).getSound());
            }
            if(e instanceof IFlyEntity) {
                System.out.println("Умеет летатать: " + ((IFlyEntity)e).getMaxFlyHeight() + " " + ((IFlyEntity)e).getMaxFlyTime());
            }
            System.out.println();
        }
    }
}
