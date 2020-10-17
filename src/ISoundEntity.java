public interface ISoundEntity
{
    //в интерфейсе нельзя размещать поля
    //private int i = 1;

    //эта функция она абстрактная
    public String getSound();

    //чтобы разместить в интерфейсе реализованную функцию
    //нужен модификатор default
    /*public default void doneFunction(String s)
    {
        System.out.println("test done function");
    }*/
}
