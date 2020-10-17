public abstract class EntityLiving
{
    private static int idCounter = 0;

    protected int id;
    protected String title;

    public EntityLiving(String title) {
        this.id = ++idCounter;
        this.title = title;
    }

    public abstract String getType();

    /*public abstract void onCreate();

    public abstract void onUpdate();

    public abstract void onDeath();*/


    @Override
    public String toString() {
        return "EntityLiving{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
