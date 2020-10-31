public class Container<T extends Comparable>
{
    private T value;

    public Container(T value) {
        this.value = value;
    }

    public void test()
    {
        System.out.println(value instanceof Integer);
    }

    @Override
    public String toString() {
        return "Container{" +
                "value=" + value +
                '}';
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
