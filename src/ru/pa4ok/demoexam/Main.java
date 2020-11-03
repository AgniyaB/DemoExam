package ru.pa4ok.demoexam;

import java.util.*;

public class Main
{
    /*
    abstract Sortinger<T exntends Comparable>
    - abstract void sort(T[] arr)
    - long sortWithTime(T[] arr)
        сохраняет в переменную текущее время
        вызывает функцию sort()
        передает туда массив
        считает и возвращает время
        потраченное на сортировку

    2-3 класса сортировщиков extends Sortinger
    реализуют функцию sort(T[] arr)
    используя разные алгоритсы сортировки
    аля BubbleSortinger<T exntends Comparable> extends Sortinger<T>
    ...

    алгоритмы сортивки
    https://proglib.io/p/java-sorting-algorithms
     */

    public static void main(String[] args)
    {
        Random rand = new Random();

        Integer[] arr1 = new Integer[10000];
        Integer[] arr2 = new Integer[10000];
        for(int i=0; i<arr1.length; i++) {
            arr1[i] = rand.nextInt(10000);
            arr2[i] = arr1[i];
        }

        BubbleSortinger<Integer> bubbleSortinger = new BubbleSortinger<>();
        QuickSortinger<Integer> quickSortinger = new QuickSortinger<>();

        System.out.println(bubbleSortinger.sortWithTime(arr1));
        System.out.println(quickSortinger.sortWithTime(arr2));
        System.out.println();
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
