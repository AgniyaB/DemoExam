package ru.pa4ok.demoexam;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        /*Random rand = new Random();
        //число от 0 до 9999
        int i = rand.nextInt(10000);

        //текущее время в миллисекундах
        long timeMills = System.currentTimeMillis();
        long alternative = (new Date()).getTime();*/

        Random rand = new Random();
        BubbleSort bubbleSort = new BubbleSort();

        int[] arr = new int[10000];
        for(int i=0; i<arr.length; i++) {
            arr[i] = rand.nextInt(5000);
        }

        System.out.println(Arrays.toString(arr));
        bubbleSort.sortWithTime(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
    interface Sortinger
    - void sort(int[] arr) [без тела / не реализоавнный]
    - default void sortWithTime(int[] arr)
        сохраняет текущее время
        вызывает метод сортировки, передает туда массив
        после окончания, выводит затраченное время

    2-3 класса
    которые реализуют интрефейс Sortinger
    с использованием различных алгоритмов сортировки

    BubbleSortinger implements Sortinger
    HeapSoritnger implements Sortinger
    ...

    чтобы не тужить алгоритмы сортировки
    можно посмотреть сюда
    https://proglib.io/p/java-sorting-algorithmsы
     */
}
