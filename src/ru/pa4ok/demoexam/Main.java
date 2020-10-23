package ru.pa4ok.demoexam;

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
        //текущее время в миликундах
        long timeMills = System.currentTimeMillis();

        //рандомное число
        Random rand = new Random();
        rand.nextInt(10000); //0-9999
    }
}
