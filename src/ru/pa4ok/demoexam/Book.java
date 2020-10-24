package ru.pa4ok.demoexam;

public class Book
{
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public static String serialize(Book book) {
        StringBuilder sb = new StringBuilder();
        sb.append(book.getId())
                .append(';')
                .append(book.getTitle())
                .append(';')
                .append(book.getAuthor());
        return sb.toString();
    }

    public static Book deserialize(String s) {
        try {
            String[] arr = s.split(";");
            return new Book(
                    Integer.parseInt(arr[0]),
                    arr[1],
                    arr[2]
            );

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
