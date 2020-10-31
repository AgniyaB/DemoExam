public class Book implements Comparable<Book>
{
    public int id;

    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.id, o.id);
    }
}
