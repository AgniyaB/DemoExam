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
        //самый яркий пример использования генериков
        //List<String> list = new ArrayList<>();
        //List<Integer> list1 = new ArrayList<>();

        /*Container<String> container = new Container<>("423432432gererg");
        System.out.println(container);

        DoubleContainer<String, Integer> doubleContainer = new DoubleContainer<>("3443tgrget", 645);
        System.out.println(doubleContainer);

        TestInterface<String> testInterface = new TestInterface<String>() {
            @Override
            public void test(String object) {
                System.out.println("test");
            }
        };*/


        //bubbleSort(new Integer[10]);
        //bubbleSort(new Container[10]);

        System.out.println(Arrays.toString(bubbleSort(new Integer[] {4, 5, 32, 23, 2, -5, 46, 100, 4, 6, 98})));
        System.out.println(Arrays.toString(bubbleSort(new Double[] {0.1, 0.3, -0.3, 0.003})));
    }

    /*//генерик можно объявить в рамках одной функции
    public static <T> void test1(T t)
    {
        T t1 = null;
    }

    public static <T> T test2()
    {
        return null;
    }

    public static <T> T test3(T t)
    {
        return null;
    }*/

    public static <T extends Comparable> T[] bubbleSort(T[] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            for(int j=i+1; j< arr.length; j++)
            {
                if(arr[i].compareTo(arr[j]) == 1)
                {
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }
}
