package ru.pa4ok.demoexam;

import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Random rand = new Random();

        long startMills1 = System.currentTimeMillis();
        String s = "rffweewfwe";
        for(int i=1; i<10000; i++) {
            s += i;
            s += ',';
            s += rand.nextInt(i);
            s += "|";
        }
        System.out.println((System.currentTimeMillis() - startMills1) + " " + s.length());

        long startMills2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("rffweewfwe");
        for(int i=1; i<10000; i++) {
            sb.append(i)
                    .append(',')
                    .append(rand.nextInt(i))
                    .append("|");
        }
        String newS = sb.toString();
        System.out.println((System.currentTimeMillis() - startMills2) + " " + newS.length());
    }
}

class Test
{
    private int i;
    private String s;
    private boolean b;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Test{");
        sb.append("i=").append(i);
        sb.append(", s='").append(s).append('\'');
        sb.append(", b=").append(b);
        sb.append('}');
        return sb.toString();
    }
}
