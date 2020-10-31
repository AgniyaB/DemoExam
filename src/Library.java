import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library
{
    private String title;
    private List<Book> books = new ArrayList<>();

    public Library(String title) {
        this.title = title;
    }

    public void readBook(Scanner scanner)
    {
        try {
            System.out.println();

            System.out.printf("Введите id: ");
            int id = Integer.parseInt(scanner.nextLine());
            if(id <= 0) {
                throw new BookReadException("Некоректный id");
            }

            System.out.printf("Введите название: ");
            String title = scanner.nextLine();
            if(title.length() < 4 || title.length() > 20) {
                throw new BookReadException("Некоректое название");
            }

            System.out.printf("Введите автора: ");
            String author = scanner.nextLine();
            if(author.length() < 4 || author.length() > 20) {
                throw new BookReadException("Некоректный автор");
            }

            Book book = new Book(id, title, author);
            books.add(book);
            System.out.println("Книга успешно добавлена: " + book);
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Неверный формат книги");
        }
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
