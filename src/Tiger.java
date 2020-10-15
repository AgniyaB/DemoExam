public class Tiger extends Animal implements ISoundEntity//, Inteface1, Iterface2...
{
    public Tiger() {
        super("млекопитающее");
    }

    @Override
    public String getSound() {
        return "рррррр";
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "type='" + type + '\'' +
                '}';
    }
}
