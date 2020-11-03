package ru.pa4ok.demoexam;

public abstract class Sortinger<T extends Comparable>
{
    public abstract void sort(T[] arr);

    public long sortWithTime(T[] arr) {
        long stratMills = System.currentTimeMillis();
        sort(arr);
        return System.currentTimeMillis() - stratMills;
    }
}
