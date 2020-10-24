import java.util.Arrays;
import java.util.Random;

public class Main
{
    /*
    abstract Sortinger
    - abstract void sort(int[] arr)
    - long sortWithTime(int[] arr)
        сохраняет время в переменную
        вызывает функцию сортировки
        считает и возвращает время
        затраченное насортировку

    3 класса extends Sortinger
    (BubbleSoringer extends Sortinger...)
    каждый класс реализует разный алгоритм сортировки

    тут можно подглядеть алгоритмы
    https://proglib.io/p/java-sorting-algorithms
     */

    public static void main(String[] args)
    {
/*
        //текущее время в милисекундах
        long timeMills = System.currentTimeMillis();

        //рандом
        Random rand = new Random();
        rand.nextInt(); //любое число
        rand.nextInt(10000); //0-9999
*/
        Random rand = new Random();

        int[] arr1 = new int[50000];
        int[] arr2 = new int[50000];

        for(int i=0; i<arr1.length; i++) {
            arr1[i] = rand.nextInt(10000);
            arr2[i] = arr1[i];
        }

        //System.out.println(Arrays.toString(arr1));
        //System.out.println(Arrays.toString(arr2));
        //System.out.println();

        BubbleSortinger bubbleSortinger = new BubbleSortinger();
        QuickSortinger quickSortinger = new QuickSortinger();

        long l1 = bubbleSortinger.sortWithTime(arr1);
        long l2 = quickSortinger.sortWithTime(arr2);

        /*System.out.println(l1 + " | " + Arrays.toString(arr1));
        System.out.println(l2 + " | " + Arrays.toString(arr1));*/

        System.out.println(l1);
        System.out.println(l2);
    }
}
