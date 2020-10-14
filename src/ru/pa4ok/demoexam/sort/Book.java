package ru.pa4ok.demoexam.sort;

public class Book implements Comparable<Book>
{
    private static int idCounter = 0;

    private int id;
    private String title;

    public Book(String title) {
        this.id = ++idCounter;
        this.title = title;
    }

    //вариант 2
    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.id, o.getId());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
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
