package ru.pa4ok.demoexam;

public class Book implements Comparable<Book>
{
    public static long idCounter = 0L;

    private long id;
    private String title;
    private String author;
    private BookStatusEnum status;

    public Book(String title, String author, BookStatusEnum status) {
        this.id = ++idCounter;
        this.title = title;
        this.author = author;
        this.status = status;
    }

    //вариант 2
    @Override
    public int compareTo(Book o) {
        return Long.compare(this.id, o.getId());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", status=" + status +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public BookStatusEnum getStatus() {
        return status;
    }

    public void setStatus(BookStatusEnum status) {
        this.status = status;
    }
}
