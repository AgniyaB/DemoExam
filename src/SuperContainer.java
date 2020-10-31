public class SuperContainer<T extends Comparable, E> extends Container<T>
{
    private E value2;

    public SuperContainer(T value, E value2) {
        super(value);
        this.value2 = value2;
    }

    public void test()
    {
        if(value2 instanceof Book) {
            Book book = (Book)value2;
        }
    }
}
