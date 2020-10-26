package ru.pa4ok.demoexam;

import java.util.Random;

public class SB
{
    public static void main(String[] args)
    {
        Random random = new Random();

        long l1 = System.currentTimeMillis();
        String s1 = "fwehfwiueefw";
        for(int i=1; i<10000; i++) {
            s1 += i;
            s1 += ',';
            s1 += random.nextInt(i);
            s1 += "|";
        }
        System.out.println((System.currentTimeMillis() - l1) + " " + s1.length());



        long l2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("fwehfwiueefw");
        for(int i=1; i<10000; i++) {
            sb.append(i)
                    .append(',')
                    .append(random.nextInt(i))
                    .append("|");
        }
        String s2 = sb.toString();
        System.out.println((System.currentTimeMillis() - l2) + " " + s2.length());
    }
}

class Test
{
    private int id;
    private String title;

    /*@Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Test{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
