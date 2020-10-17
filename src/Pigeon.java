public class Pigeon extends Animal implements ISoundEntity, IFlyEntity
{
    public Pigeon() {
        super("Голубь");
    }

    @Override
    public String getType() {
        return "птица";
    }

    @Override
    public String getSound() {
        return "курлык";
    }

    @Override
    public int getMaxFlyTime() {
        return 120;
    }

    @Override
    public double getMaxFlyHeight() {
        return 20.5D;
    }

    @Override
    public String toString() {
        return "Pigeon{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
