public abstract class EntityLiving
{
    protected String type;

    public EntityLiving(String type) {
        this.type = type;
    }

    public abstract void test();

    @Override
    public String toString() {
        return "EntityLiving{" +
                "type='" + type + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
