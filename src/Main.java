import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Random rand = new Random();

        long l1 = System.currentTimeMillis();
        String s = "wefwefef3";
        for(int i=1; i<10000; i++)
        {
            s += i;
            s += ',';
            s += rand.nextInt(i);
            s += "|";
        }
        System.out.println((System.currentTimeMillis() - l1) + " " + s.length());


        long l2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("wefwefef3");
        for(int i=1; i<1000000; i++)
        {
            sb.append(i)
                    .append(',')
                    .append(rand.nextInt(i))
                    .append("|");
        }
        String s1 = sb.toString();
        System.out.println((System.currentTimeMillis() - l2) + " " + s1.length());
    }
}

class Test
{
    private int id;
    private String title;

    public Test(int id, String title) {
        this.id = id;
        this.title = title;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

