package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main
{
    /*
    interface Sortinger<T extends Comparable>
    - void sort(T[] arr) [без тела / не реализоавнный]
    - default long sortWithTime(T[] arr)
        сохраняет текущее время
        вызывает метод сортировки, передает туда массив
        возвращает затраченное время

    2-3 класса
    которые реализуют интрефейс Sortinger
    с использованием различных алгоритмов сортировки

    BubbleSortinger<T extends Comparable> implements Sortinger<T>
    HeapSoritnger<T extends Comparable> implements Sortinger<T>
    ...
    чтобы не тужить алгоритмы сортировки
    можно посмотреть сюда
    https://proglib.io/p/java-sorting-algorithmsы
     */

    public static void main(String[] args)
    {
        Random rand = new Random();

        Integer[] integers = new Integer[10000];
        for(int i=0; i<integers.length; i++) {
            integers[i] = rand.nextInt(10000);
        }

        Arrays.toString(integers);
        BubbleSortinger bubbleSortinger = new BubbleSortinger();
        System.out.printf(bubbleSortinger.sortWithTime(integers) + " " + Arrays.toString(integers));
    }
}
