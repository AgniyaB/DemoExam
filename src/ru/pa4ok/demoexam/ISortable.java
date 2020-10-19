package ru.pa4ok.demoexam;

public interface ISortable
{
    public void sort(int[] arr);

    public default void sortWithTime(int[] arr)
    {
        long startMills = System.currentTimeMillis();
        sort(arr);
        System.out.println(System.currentTimeMillis() - startMills);
    }
}
