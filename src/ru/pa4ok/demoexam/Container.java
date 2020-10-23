package ru.pa4ok.demoexam;

public class Container<T extends Comparable>
{
    private T field;

    public Container(T field) {
        this.field = field;
    }

    public void test()
    {
        System.out.println(field instanceof String);
    }


    @Override
    public String toString() {
        return "Container{" +
                "field=" + field +
                '}';
    }

    public T getField() {
        return field;
    }

    public void setField(T field) {
        this.field = field;
    }
}
