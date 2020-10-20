package ru.pa4ok.demoexam;

public abstract class EntityLiving
{
    protected String type;

    public EntityLiving(String type) {
        this.type = type;
    }

    //абстрактная функция
    public abstract void test(int i);

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
