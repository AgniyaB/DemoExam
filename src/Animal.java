public class Animal extends EntityLiving
{
    public Animal(String type) {
        super(type);
    }

    /*
    если обычный класс наследует абстрактный
    то он должен реализовать все его абстрактные методы

    если абстракный класс наследует абстрактный
    то можно не реализовать все методы
     */
    @Override
    public void test()
    {
        System.out.println("test from Animal");
    }
}
