package ru.pa4ok.demoexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main
{
    /*
    abstract Sortinger<T extends Comparable>
    - abstract void sort(T[] arr)
        сортировать массив
    - void sortWithTime(T[] arr)
        сохраняет в переменную текущее время
        вызывает метод sort(T[] arr)
        вычисляет и выводит время затраченное на сортировку

    2 или 3 класса наследуют ваш Sortinger
    аля BubbleSortinger<T extends Comparable> extends Sortinger<T>
    с РАЗНЫМИ алгоритмами сортивки
     */

    public static void main(String[] args)
    {
        //самый яркий пример использование генерика
        //List<String> list = new ArrayList<>();

        //Container<String> stringContainer = new Container<>("test string");
        //System.out.println(stringContainer);

        /*Container<int> нельзя
        Container<Integer> можно */

        //нельзя создать такое объект так как TestClass не реализует интерфейс Comparable
        //Container<TestClass> c1 = new Container<TestClass>();

        //Tuple<Integer, String> tuple = new Tuple<>(213, "fgegregr");
        //System.out.println(tuple);

        Integer[] arr = {35, 33, 3, 10, 40, 6, 15, 4, 6, 20, 1};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));

        //текущее время в милисекундах
        long timeMills = System.currentTimeMillis();

        //рандом
        Random rand = new Random();
        int randInt = rand.nextInt(1000);
    }

    private static <T extends Comparable> void sortArray(T[] arr)
    {
        //можно проверить генерик на принадлежность к классу
        /*T t = null;
        if(t instanceof String) {
            //...
        }*/

        for(int i=0; i<arr.length; i++)
        {
            for(int j=i; j<arr.length; j++)
            {
                /*
                -1 a<n
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
    }
}

class TestClass
{

}
