package ru.pa4ok.appname.task;

public abstract class Sortinger<T extends Comparable<T>>
{
    public final String title;

    public Sortinger(String title) {
        this.title = title;
    }

    public abstract void sort(T[] arr);
}
