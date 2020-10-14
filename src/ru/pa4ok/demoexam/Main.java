package ru.pa4ok.demoexam;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        /*Container<String> c1 = new Container<>("string");
        Container<Integer> c2 = new Container<>(44);

        System.out.println(c1);
        System.out.println(c2);

        */

        //Tuple<Integer, String> t1 = new Tuple<>(1, "12fwwefwe");
        //System.out.println(t1.getFirst() + " | " + t1.getSecond());

        //testGenerik("4234324");
        //testGenerik(443);

        //Integer i = 434;

        Integer[] arr = {2, 6, 4, 1, 54, 4, 10, 3, 4};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));

        //TestClass[] arr2 = new TestClass[10];
        //sortArray(arr2);
    }

    private static <T extends Comparable> void sortArray(T[] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                /*
                compare() compareTo()
                a и b
                -1 a<b
                0 a==b
                1 a>b
                 */

                if(arr[i].compareTo(arr[j]) == 1)
                {
                    T t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }

        //long timeMills = System.currentTimeMillis();
    }

       /* private static <T> void testGenerik(T t)
    {
        System.out.println(t instanceof String);
        System.out.println(t);
    }*/

    /*
    abstract Sortinger<T extends Comparable>
    - abstract void sort(T[] arr) //метод без тела (абстрактный)
    - void sortWithTime(T[] arr)
        сохранять в перемененую текущее время
        вызывать sort(T[] arr)
        и выводить в консоль время потраченное на сортировку

    BubbleSortinger extends Sortinger
    - реализовать sort(T[] arr)
        сортировка пузырьком

    +еще 2 класса с любыми другими алгоритимами сортировки
     */
}
