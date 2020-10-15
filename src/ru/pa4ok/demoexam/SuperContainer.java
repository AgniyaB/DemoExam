package ru.pa4ok.demoexam;

public class SuperContainer<T extends Comparable> extends Container<T>
{
    public SuperContainer(T value) {
        super(value);
    }

    @Override
    public String
    toString() {
        return "SuperContainer{" +
                "value=" + value +
                '}';
    }
}
