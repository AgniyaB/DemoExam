package ru.pa4ok.demoexam;

public class Main
{
    public static void main(String[] args)
    {
        /*int intValue = 0;
        float floatValue = 2.34324234F; //32b
        double doubleValue = 3232423432.34234D; //64b
        boolean booleanValue = true;
        char charValue = 'a';
        Integer integer = null;
        String nullString;
        String stringValue = "sdfwsedfdsfwefw";
        System.out.println(stringValue.substring(3, 7));
        if(floatValue > intValue) {
            System.out.println("true");
        }
        System.out.println("rewerrgtew".equals(stringValue));

        int[] intArr = new int[10];
        System.out.println(intArr[0]);
        Integer[] integers = new Integer[10];
        System.out.println(integers[0]);

        for(int i=0; i<intArr.length; i++) {
            intArr[i] = i;
        }

        for(int i : intArr) {
            System.out.printf(i + " ");
        }*/

        Student student = new Student("Данила", 23, "Филипов");
        System.out.println(student);
        System.out.println(student.getName() + " " + student.getSurname());
        student.print("3245324", "fweewffew", "fewfew");
        //PrivateStudent privateStudent = new PrivateStudent();

        //Scanner in = new Scanner(System.in);
        //System.out.println(5 + in.nextInt(16));
        //Integer v = 15;
        //System.out.println(v.toString());
        //in.close();
    }
}

//область видимости - этот файл и файлы в 1 пакете
class TestMain
{

}