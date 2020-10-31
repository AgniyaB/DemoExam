import java.net.CookiePolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main
{
    /*
    abstract Sortinger<T extends Comparable>
    - abstract void sort(T[] arr)
    - void sortWithTime(T[] arr)
        сохранить время до сортировки
        вызывать метод сортировки
        посчитать и вывести время затраченное на сортировку

    3 и более классов которые наследуют Sortinger
    и реализуют РАЗЛИЧНЫЕ алгоритмы сортировки

    BubbleSortinger<T extends Comparable> extends Sortinger<T>
    SelectionSortinger<T extends Comparable> extends Sortinger<T>
    ...

    //https://proglib.io/p/java-sorting-algorithms
    */

    public static void main(String[] args)
    {
        Random rand = new Random();

        Integer[] arr = new Integer[100000];
        for(int i=0; i<arr.length; i++) {
            arr[i] = rand.nextInt(10000);
        }

        BubbleSortinger bubbleSortinger = new BubbleSortinger();
        System.out.println(bubbleSortinger.sortWithTime(arr.clone()));

        QiuckSortinger qiuckSortinger = new QiuckSortinger();
        System.out.println(qiuckSortinger.sortWithTime(arr.clone()));
    }
}
