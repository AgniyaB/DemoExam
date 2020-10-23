package ru.pa4ok.demoexam;

import java.util.Arrays;
import java.util.Random;

public class Main
{
    /*
    abstract Sortinger
    - abstract void sort(int[] arr)
    - long sortWithTime(int[] arr)
        сохраняет в переменную текущее время
        вызывает функцию sort()
        передает туда массив
        считает и возвращает время
        потраченное на сортировку

    2-3 класса сортировщиков extends Sortinger
    реализуют функцию sort(int[] arr)
    используя разные алгоритсы сортировки
    аля BubbleSortinger exntends Sortinger
    ...

    алгоритмы сортивки
    https://proglib.io/p/java-sorting-algorithms
     */

    public static void main(String[] args)
    {
        /*
        //текущее время в миликундах
        long timeMills = System.currentTimeMillis();

        //рандомное число
        Random rand = new Random();
        rand.nextInt(10000); //0-9999
        */

        int[] arr1 = new int[100000];
        int[] arr2 = new int[100000];


        Random rand = new Random();
        for(int i=0; i<arr1.length; i++) {
            arr1[i] = rand.nextInt(1000);
        }
        for(int i=0; i<arr2.length; i++) {
            arr2[i] = rand.nextInt(1000);
        }

        BubbleSortinger bubbleSortinger = new BubbleSortinger();
        System.out.println(bubbleSortinger.sortWithTime(arr1));

        QiuckSortinger qiuckSortinger = new QiuckSortinger();
        System.out.println(qiuckSortinger.sortWithTime(arr2));

        //System.out.println();
        //System.out.println(Arrays.toString(arr1));
        //System.out.println(Arrays.toString(arr2));

    }
}
