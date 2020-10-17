public class Microbe extends EntityLiving
{
    private boolean danger;

    public Microbe(boolean danger) {
        super();
        this.danger = danger;
    }

    @Override
    public String getType() {
        return "бактерия";
    }

    @Override
    public boolean canPet() {
        return false;
    }

    @Override
    public String toString() {
        return "Microbe{" +
                "danger=" + danger +
                '}';
    }
}
