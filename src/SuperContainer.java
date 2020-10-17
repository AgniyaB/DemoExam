/*
//вариант 1, отправляем тип данных
public class SuperContainer extends Container<String>
{
    public SuperContainer(String value) {
        super(value);
    }
}
*/

//вариант 2, продолжаем делать генерики
public class SuperContainer<T> extends Container<T>
{
    public SuperContainer(T value) {
        super(value);
    }
}