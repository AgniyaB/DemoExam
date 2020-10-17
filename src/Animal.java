public abstract class Animal extends EntityLiving
{
    public Animal(String title) {
        super(title);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
