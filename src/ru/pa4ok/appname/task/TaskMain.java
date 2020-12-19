package ru.pa4ok.appname.task;

import java.util.Arrays;
import java.util.Random;

public class TaskMain
{
    public static void main(String[] args)
    {
        Random random = new Random();
        BubbleSortinger<Integer> bubbleSortinger = new BubbleSortinger<>();
        QuickSortinger<Integer> quickSortinger = new QuickSortinger<>();

        int length = 10000;
        Integer[] arr1 = new Integer[length];
        Integer[] arr2 = new Integer[length];
        for(int i=0; i<arr1.length; i++) {
            arr1[i] = random.nextInt(99999);
            arr2[i] = arr1[i];
        }
        //System.out.println(Arrays.toString(arr1));
        //System.out.println(Arrays.toString(arr2));
        //System.out.println();

        long startMills = System.currentTimeMillis();
        bubbleSortinger.sort(arr1);
        System.out.println("Массив отсортирован за " + (System.currentTimeMillis() - startMills) + "ms");
        startMills = System.currentTimeMillis();
        quickSortinger.sort(arr2);
        System.out.println("Массив отсортирован за " + (System.currentTimeMillis() - startMills) + "ms");

        //System.out.println();
        //System.out.println(Arrays.toString(arr1));
        //System.out.println(Arrays.toString(arr2));
    }
}
