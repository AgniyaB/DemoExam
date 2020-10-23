package ru.pa4ok.demoexam;

public interface Sortinger<T extends Comparable>
{
    public void sort(T[] arr);

    public default long sortWithTime(T[] arr)
    {
        long startMills = System.currentTimeMillis();
        sort(arr);
        return System.currentTimeMillis() - startMills;
    }
}
