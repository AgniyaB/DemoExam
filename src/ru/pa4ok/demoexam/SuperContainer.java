package ru.pa4ok.demoexam;

public class SuperContainer<T extends Comparable, E> extends Container<T>
{
    private E newObject;

    public SuperContainer(T object, E newObject) {
        super(object);
        this.newObject = newObject;
    }

    public E getNewObject() {
        return newObject;
    }

    public void setNewObject(E newObject) {
        this.newObject = newObject;
    }
}
