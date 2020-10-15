public class Microbe extends EntityLiving
{
    public Microbe() {
        super("бактерия");
    }

    @Override
    public void test() {
        System.out.println("test from Microbe");
    }

    @Override
    public String toString() {
        return "Microbe{" +
                "type='" + type + '\'' +
                '}';
    }
}
