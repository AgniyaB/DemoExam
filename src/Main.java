import java.util.*;

public class Main
{
    /*
    abstract Sortinger<T extends Comparable>
    - abstract void sort(T[] arr)
    - void sortWithTime(T[] arr)
        //сохраняет время
        //вызывает метод sort(T[] arr)
        //вычисляет и выводит время
        //затраченное на сортировку

    2-3 класса extends Sortinger
    и реализуют различные алгоритмы сортировки
    BubbleSortinger<T extends Comparable> extends Sortinger<T>
    ...
    ...
     */

    public static void main(String[] args)
    {
        //самое яркое применение генерика
        //List<String> list = new ArrayList<>();

        //Container<String> container = new Container<>("lhgwroreg");
        //System.out.println(container);

        //Container<int> //так нельзя
        //Container<Integer>

        //test2("ewfwfewfe");
        //test2(3454);

       /* List<Book> books = new ArrayList<>();
        for(int i=0; i<5; i++) {
            books.add(new Book());
        }
        System.out.println(books);

        Collections.shuffle(books);
        System.out.println(books);*/

        //вариант 1
        /*Collections.sort(books, new Comparator<Book>() {
            //-1 o1<o2
            //0 01==2
            //1 o1>o2
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare(o2.id, o1.id);
            }
        });
        System.out.println(books);*/

        //вариант 2 + см. интерфейс Comparable в Book
        /*Collections.sort(books);
        System.out.println(books);*/

        Integer[] arr = {234, 4, 645, 43, 32, 5, 3, -1, 20, 30, 3, 1, 0, 34};
        sortArr(arr);
        System.out.println(Arrays.toString(arr));

        //даже нельзя вызвать метод не подходядий под обобщение
        //Container<Integer>[] arr1 = new Container[10];
        //sortArr(arr1);

        //текущее время в милискундах
        long timeMills = System.currentTimeMillis();

        //рандомное число
        Random rand = new Random();
        int i = rand.nextInt(1000);;

    }

    /*private static <T> void test1(T t)
    {

    }*/

    /*private static <T> T test2(T t)
    {
        if(t instanceof String) {
            String s = (String)t;
            System.out.println(s.toUpperCase());
        } else {
            System.out.println(t);
        }

        return t;
    }*/

    private static <T extends Comparable> void sortArr(T[] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            for(int j=i; j<arr.length; j++)
            {
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
