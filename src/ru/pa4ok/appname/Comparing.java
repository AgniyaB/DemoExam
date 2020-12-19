package ru.pa4ok.appname;

import java.util.Arrays;

public class Comparing
{
    /*
    abstract Sortinger<T extends Comparable<T>>
    - String title
    - public abstract void sort(T[] arr)

    BubbleSortinger<T extends Comparable<T>> extends Sortinger<T>
    передаст в родительский конструктор super(пузырек)
    реализует метод соритивку выбранным алгоритмом

    задача сделать BubbleSortinger с реализацией а также еще
    класса с любыми другими алгоритмами сортировки
    https://proglib.io/p/java-sorting-algorithms
    не берите сортировку слиянием, там будет сложный момент с инициализацией массивов
     */

    public static void main(String[] args)
    {
        //String s1 = "worhfqhfdfhqwdjwqd";
        //String s2 = "fjoiewiohf43uf43";

        //так делать не кореектно потому что строки это сложные объекты
        //if(s1 == s2)

        //System.out.println(s1.equals(s2));
        //System.out.println(s1.equalsIgnoreCase(s2));

        Integer[] arr1 = {44, 23, 45, 2, 5, 56, 3, 87, 87, 1};
        System.out.println(Arrays.toString(arr1));
        sortArray(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    //можно объявить генерик в рамках одного метода
    public static <T extends Comparable<T>> void sortArray(T[] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[j].compareTo(arr[i]) == -1)
                {
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}

class MyEntity implements Comparable<MyEntity>
{
    public int id;
    public String s;
    public double d;

    public MyEntity(int id, String s, double d) {
        this.id = id;
        this.s = s;
        this.d = d;
    }

    @Override
    public int compareTo(MyEntity o) {
        /*
        -1 - первый меньше второго
        0 - равны
        1 - первый больше второго
         */
        return Integer.compare(this.id, o.id);
    }
}

