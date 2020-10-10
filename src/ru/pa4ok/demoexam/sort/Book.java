package ru.pa4ok.demoexam.sort;

public class Book implements Comparable<Book>
{
    private static long idCounter = 0L;

    private long id;
    private String title;
    private String author;

    public Book(String title, String author) {
        this.id = ++idCounter;
        this.title = title;
        this.author = author;
    }

    //вариант 2
    @Override
    public int compareTo(Book o) {
        return Long.compare(this.getId(), o.getId());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
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
}
