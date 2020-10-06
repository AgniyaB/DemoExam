package ru.pa4ok.demoexam.maps;

public class Book
{
    private static int idCounter = 0;

    private int id;
    private String title;
    private String autor;

    public Book(String title, String autor) {
        this.id = ++idCounter;
        this.title = title;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", autor='" + autor + '\'' +
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
