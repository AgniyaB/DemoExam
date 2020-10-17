import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Zoo
{
    private String address;
    private List<EntityLiving> animals = new ArrayList<>();

    public Zoo(String address) {
        this.address = address;
    }

    public List<IFlyEntity> getAllFlyEntities()
    {
        List<IFlyEntity> list = new ArrayList<>();

        for(EntityLiving e : animals)
        {
            if(e instanceof IFlyEntity) {
                list.add((IFlyEntity) e);
            }
        }

        return list;
    }

    public void playAllAnimalSounds()
    {
        List<String> list = new ArrayList<>();
        for(EntityLiving e : animals)
        {
            if(e instanceof ISoundEntity) {
                String sound = ((ISoundEntity)e).getSound();
                if(!list.contains(sound)) {
                    list.add(sound);
                }
            }
        }
        System.out.println(list);

        //сеты не хранят повторяющикся элементы
        /*Set<String> set = new HashSet<>();
        for(EntityLiving e : animals)
        {
            if(e instanceof ISoundEntity) {
                set.add(((ISoundEntity)e).getSound());
            }
        }
        System.out.println(set);*/
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "address='" + address + '\'' +
                ", animals=" + animals +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<EntityLiving> getAnimals() {
        return animals;
    }

    public void setAnimals(List<EntityLiving> animals) {
        this.animals = animals;
    }
}
