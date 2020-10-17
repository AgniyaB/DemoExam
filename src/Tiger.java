public class Tiger extends EntityLiving implements ISoundEntity
{
    public Tiger() {
        super();
    }

    @Override
    public String getType() {
        return "млекопитающее";
    }

    @Override
    public boolean canPet() {
        return false;
    }

    @Override
    public String getSound() {
        return "рррррр";
    }

    @Override
    public String toString() {
        return "Tiger{}";
    }
}
