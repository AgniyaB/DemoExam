import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Random random = new Random();

        String s1 = "frwedwfwfe";
        long startTime1 = System.currentTimeMillis();
        for(int i=1; i<10000; i++)
        {
            s1 += i;
            s1 += '|';
            s1 += random.nextInt(i);
            s1 += ",";
        }
        System.out.println((System.currentTimeMillis() - startTime1) + " " + s1);

        StringBuilder sb = new StringBuilder("frwedwfwfe");
        long startTime2 = System.currentTimeMillis();
        for(int i=1; i<100000; i++)
        {
            sb.append(i)
                    .append('|')
                    .append(random.nextInt(i))
                    .append(",");
        }
        System.out.println((System.currentTimeMillis() - startTime2));
    }
}
