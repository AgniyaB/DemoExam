package ru.pa4ok.demoexam;

public class EntityLiving
{
    protected String type;

    public EntityLiving(String type) {
        this.type = type;
    }

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
