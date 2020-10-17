public class Book implements Comparable<Book>
{
    private static int idCounter = 0;

    public int id;

    public Book() {
        this.id = ++idCounter;
    }

    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.id, o.id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                '}';
    }
}
