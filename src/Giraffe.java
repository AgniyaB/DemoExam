public class Giraffe extends Animal implements ISoundEntity
{
    public Giraffe() {
        super("Жирафв");
    }

    @Override
    public String getType() {
        return "млекопитающее";
    }

    @Override
    public String getSound() {
        return "эаоуэа";
    }

    @Override
    public String toString() {
        return "Giraffe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
