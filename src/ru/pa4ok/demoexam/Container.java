package ru.pa4ok.demoexam;

public class Container<T extends Comparable>
{
    private T object;

    public Container(T object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Container{" +
                "object=" + object +
                '}';
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
