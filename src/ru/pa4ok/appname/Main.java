package ru.pa4ok.appname;

import ru.pa4ok.test.Note;

public class Main
{
    /*
    быстрое продолжение
        psvm - главнвый метод main
        sout - принтл с новой строкой
        souf - принт без новой строки

    комбинации
    alt + insert - генерация конструкторов, toString, геттеров и сеттеров
    alt + enter - предложение вариантов по исправлению ошибок
    если ноут и insert на 2 действии кнопки то alt + fn + insert
     */

    /*
    Person
    - int id
    - String firstname
    - String surname
    - int age

    должен быть переопределен метод toString()
    все поля private + геттеры и сеттеры

    сделать массив из Person
    и в цикле его заполнить
    пример: new Person(i, "firstname-" + i, "surname-" + i....)
    вывести массив в консоль
     */

    public static void main(String[] args)
    {
        /*//System.out.println("Hello World " + 228);

        //у примитивов есть дефолтные значения
        int i = 4;
        char c = '~';
        boolean booleanValue = false;
        float f = 3.5445F;
        double d = 3.432432D;

        String s; //по умолчанию null
        String s1 = "";
        String s2 = "iueFIEfgiugf23";
        //в строках сразу вложены все методы
        System.out.println(s2.substring(3, 6));

        int[] intArr; //сейчас массив null

        int[] intArr1 = new int[10];
        System.out.println(intArr1[0]); //0

        String[] strArr = new String[10];
        System.out.println(strArr[0]); //null
        strArr[0] = "test1234";
        System.out.println(strArr[0]);

        //все примитивы имееют свои глобальные классы
        //по умолчанию как и любые сложные типы данных они равны null

        int i2; //0
        Integer integer; //null

        Character character;
        Boolean bool;
        Float floatGlobal;
        Double doubleGlobal;

        String intString = "343434";
        int i3 = Integer.parseInt(intString);
        i3 += 10000000;
        System.out.println("result" + i3);

        Boolean.parseBoolean("false");
        Float.parseFloat("4.543434343");
        Double.parseDouble("3.324348");*/

        int[] arr = new int[10];
        /*for(int i=0; i<arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
        System.out.println();
        for(int i=0; i<arr.length; i++) {
            arr[i] = 9-i;
        }
        for(int i=0; i<arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
        System.out.println();*/
        /*System.out.println(Arrays.toString(arr));
        for(int i=0; i<arr.length; i++) {
            arr[i] = 9-i;
        }
        System.out.println(Arrays.toString(arr));

        int temp = 0;
        for(int i : arr) {
            temp += i;
        }
        System.out.println(temp);*/

        /*while(true) {
            //...
        }
        for(;;) {
            //...
        }*/

        /*Book book = new Book(1, "vozna i mir", "pushkin");
        //System.out.println(book);
        System.out.println(book.author);*/

        Note note = new Note(0, "olehfewbfew4543ogho34ht");
        System.out.println(note.getText());
    }
}
