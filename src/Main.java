import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        //время в милисекундах
        long timeMills = System.currentTimeMillis();

        //рандом
        Random random = new Random();
        random.nextInt(); //вообще любое рандомное число
        random.nextInt(10000); //от 0 до 9999
    }

    /*
    abstract Sortinger
    - abstract void sort(int[] arr)
    - void sortWithTime(int[] arr)
        сохранить время до сортировки
        вызывать метод сортировки
        посчитать и вывести время затраченное на сортировку

    3 и более классов которые наследуют Sortinger
    и реализуют РАЗЛИЧНЫЕ алгоритмы сортировки

    BubbleSortinger extends Sortinger
    SelectionSortinger extends Sortinger
    ...
    //https://proglib.io/p/java-sorting-algorithms
    */
}
