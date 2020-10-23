package ru.pa4ok.demoexam;

public class BubbleSortinger<T extends Comparable> implements Sortinger<T>
{
    @Override
    public void sort(T[] arr) {
        for(int i=0; i< arr.length; i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[i].compareTo(arr[j]) == 1)
                {
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
