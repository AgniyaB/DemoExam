package ru.pa4ok.demoexam;

public abstract class EntityLiving
{
    public EntityLiving() {
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "EntityLiving{}";
    }

    /*private int intValue;
    protected String a = "ewfdew";

    public void test()
    {
        //new TestClass();
    }

    //шаблон или "заготовка функции"
    public abstract String getString();*/
}

/*
//вы должны либо реализовать функцию
class TestClass extends EntityLiving
{
    @Override
    public String getString() {
        return "123";
    }
}

//либо декларировать класс наследник как abstract
abstract class Test2Class extends EntityLiving
{

}
*/
