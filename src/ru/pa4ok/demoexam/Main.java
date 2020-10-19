package ru.pa4ok.demoexam;

import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        //StringBuilding при большом количестве операций по изменению строк
        //работает в СОТНИ раз быстрее

        Random rand = new Random();

        long startMills1 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("4323423");
        for(int i =1; i<10000; i++)
        {
            sb.append(i)
                    .append("-")
                    .append(rand.nextInt(i))
                    .append("|");
        }
        System.out.println(sb);
        System.out.println(System.currentTimeMillis() - startMills1);
        //String s = sb.toString();

        System.out.println();

        long startMills2 = System.currentTimeMillis();
        String s = "4323423";
        for(int i =1; i<10000; i++)
        {
            s += i;
            s += "-";
            s += rand.nextInt(i);
            s += "|";
        }
        System.out.println(s);
        System.out.println(System.currentTimeMillis() - startMills2);
    }
}
