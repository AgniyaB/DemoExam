public abstract class EntityLiving
{
    public EntityLiving() {
    }

    public abstract String getType();

    public abstract boolean canPet();

    @Override
    public String toString() {
        return "EntityLiving{}";
    }
}
