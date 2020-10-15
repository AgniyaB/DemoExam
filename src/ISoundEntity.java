public interface ISoundEntity
{
    //в интерфейсе нельзя размещать поля
    //private int i = 1;

    //такая функция уже абстрактная
    public String getSound();

    //чтобы поместить реализованную функицю
    // нужен модификатор default
    public default void doneFunction() {
        System.out.println("test");
    }
}
