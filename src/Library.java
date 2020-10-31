import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Library
{
    private String title;
    private List<Book> books = new ArrayList<>();

    public Library(String title) {
        this.title = title;
    }

    public Library() throws Exception {
        load();
    }

    public void save() throws IOException
    {
        BufferedWriter bw = Files.newBufferedWriter(Paths.get("lib.txt"));

        bw.write(title);
        bw.newLine();

        for(Book b : books) {
            bw.write(b.getId() + ";" + b.getTitle() + ";" + b.getAuthor());
            bw.newLine();
        }

        bw.close();
    }

    public void load() throws Exception {
        BufferedReader br = Files.newBufferedReader(Paths.get("lib.txt"));

        boolean first = false;
        String s;
        while((s = br.readLine()) != null) {
            if(!first) {
                title = s;
                first = true;
                continue;
            }

            String[] arr = s.split(";");
            books.add(new Book(
                    Integer.parseInt(arr[0]),
                    arr[1],
                    arr[2]
            ));
        }

        br.close();
    }

    @Override
    public String toString() {
        return "Library{" +
                "title='" + title + '\'' +
                ", books=" + books +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
