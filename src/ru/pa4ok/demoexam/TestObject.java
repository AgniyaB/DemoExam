package ru.pa4ok.demoexam;

//этот класс нельзя будет унаследовать
public final class TestObject
{
    //доступно везде
    public final int publicValue;
    //только в классе где объект
    private int privateValue;
    //из одного пакета или классов наследников
    protected int protectedValue;

    public TestObject(int publicValue, int privateValue, int protectedValue) {
        this.publicValue = publicValue;
        this.privateValue = privateValue;
        this.protectedValue = protectedValue;
    }

    /*@Override
    public String toString()
    {
        //return "" + this.value;
        return String.valueOf(this.value);
    }*/

    @Override
    public String toString() {
        return "TestObject{" +
                "publicValue=" + publicValue +
                ", privateValue=" + privateValue +
                ", protectedValue=" + protectedValue +
                '}';
    }

    //класс унаследовавший не сможет переопределить
    public final void test()
    {
        //publicValue = 10;
        System.out.println("public test");
    }

    private void test1()
    {
        System.out.println("private test");
    }

    protected void test2() {
        System.out.println("protected test");
    }

    public int getSumm()
    {
        return this.privateValue + this.publicValue + this.protectedValue;
    }
}
