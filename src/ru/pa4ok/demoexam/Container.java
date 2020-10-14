package ru.pa4ok.demoexam;

public class Container<T>
{
    private T obj;

    public Container(T obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "Container{" +
                "obj=" + obj +
                '}';
    }


    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
