package ru.pa4ok.appname.task;

public class QuickSortinger<T extends Comparable<T>> extends Sortinger<T>
{
    public QuickSortinger() {
        super("Быстрая сортировка");
    }

    @Override
    public void sort(T[] arr)
    {
        quickSort(arr, 0, arr.length-1);
    }

    private void quickSort(T[] array, int begin, int end)
    {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot+1, end);
    }

    private int partition(T[] array, int begin, int end)
    {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++)
        {
            if (array[i].compareTo(array[pivot]) == -1)
            {
                T temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        T temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }
}
