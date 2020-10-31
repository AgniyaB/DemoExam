import java.net.CookiePolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        //List<String> list = new ArrayList<>();

        /*Container<Integer> integerContainer = new Container<>(422);
        System.out.println(integerContainer);
        integerContainer.test();*/

        Integer[] arr = {34, 21, 5, -5, 100, 34, 86, 8, 56, 4, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static <T extends Comparable> void sort(T[] arr)
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

    /*public static <T> T test(T in) {
        T t = null;
        return t;
    }*/
}
