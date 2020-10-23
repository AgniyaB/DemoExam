package ru.pa4ok.demoexam;

public class SuperContainer<T extends Comparable> extends Container<T>
{
    public SuperContainer(T field) {
        super(field);
    }
}
