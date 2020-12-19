package ru.pa4ok.appname.task;

public class BubbleSortinger<T extends Comparable<T>> extends Sortinger<T>
{
    public BubbleSortinger() {
        super("Пузырек");
    }

    @Override
    public void sort(T[] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[j].compareTo(arr[i]) == -1)
                {
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
