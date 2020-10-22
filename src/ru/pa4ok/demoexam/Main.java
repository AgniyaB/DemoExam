package ru.pa4ok.demoexam;

import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Random rand = new Random();

        long startMills1 = System.currentTimeMillis();
        String s = "34234gfrttrgerg";
        for(int i=1; i<10000; i++) {
            s += i;
            s += ',';
            s += rand.nextInt(i);
            s += "|";
        }
        System.out.println((System.currentTimeMillis() - startMills1) + " " + s);


        long startMills2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("34234gfrttrgerg");
        for(int i=1; i<1000000; i++) {
            sb.append(i)
                    .append(',')
                    .append(rand.nextInt(i))
                    .append("|");
        }
        System.out.println((System.currentTimeMillis() - startMills2));
    }
}
