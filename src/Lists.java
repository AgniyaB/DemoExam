import java.util.*;

public class Lists
{
    public static void main(String[] args)
    {
        /*List<String> list = new ArrayList<>();

        list.add("efgrghg");
        list.add("342354243");
        list.add("342234ghrgh");*/

        /*list.remove(2); // удаление по индексу
        System.out.println(list);
        list.remove("efgrghg"); // удаление по объекту*/

        /*list.size();
        list.isEmpty();
        list.clear();*/

        /*System.out.println(list.contains("g;rgjjrgerg"));
        System.out.println(list.contains("342354243"));*/

        /*System.out.println(list);
        System.out.println(list.get(1));
        list.set(1, "new string");*/

        /*for(String s : list) { // в s приходит копия объекта из листа
        }

        for(int i=0; i<list.size(); i++) {
            String s = list.get(i);
        }*/

        //System.out.println(list);

        /*String[] arr = {"324324", "2234", "321321"};
        List<String> newList = Arrays.asList(arr);
        List<String> newList2 = Arrays.asList("324324", "2234", "321321");

        System.out.println(newList);
        System.out.println(newList2);*/

        Map<Integer, NewStudent> map = new HashMap<>();

        NewStudent student1 = new NewStudent(1, "Vasya");
        map.put(student1.getId(), student1);
        map.put(2, new NewStudent(2, "Petya"));

        /*System.out.println(map.get(1));
        System.out.println(map.get(2));*/

        /*for(NewStudent s : map.values()) {
            //...
        }

        List<NewStudent> list = new ArrayList<>(map.values());
        */

        /*for(Map.Entry<Integer, NewStudent> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }*/

        System.out.println(map);
    }

    /*//примерная логика Arrays.asList
    private static <T> List<T> myAsList(T... objects)
    {
        List<T> list = new ArrayList<>();
        for(T t : objects) {
            list.add(t);
        }
        return list;
    }*/
}
