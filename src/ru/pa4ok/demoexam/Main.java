package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        //самый яркий пример использования генериков
        //List<String> list = new ArrayList<>();

        Container<String> stringContainer = new Container<>("fefqff");
        Container<Integer> integerContainer = new Container<>(343443);

        stringContainer.test();
        integerContainer.test();

        //Integer i = 10;
        //i.compareTo(11);
        //sort(new Integer[0]);
        //sort(new Container<?>[0]);

        Integer[] integers = {32, 43, 45, 3, 5, -4, 54, 4, 654, 43, 2, 4, 11};
        sort(integers);
        System.out.println(Arrays.toString(integers));
    }

    /*public static <T,E> E test(T value)
    {
        return null;
    }*/

    private static <T extends Comparable> void sort(T[] arr)
    {
        for(int i=0; i<arr.length; i++)
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
