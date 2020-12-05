package ru.pa4ok.appname;

import java.util.Arrays;

public class Book
{
    private String title;
    private String author;
    private Chapter[] chapters;

    public Book(String title, String author, Chapter[] chapters) {
        this.title = title;
        this.author = author;
        this.chapters = chapters;
    }

    public Book(String title, String author) {
        this(title, author, new Chapter[2]);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", characters=" + Arrays.toString(chapters) +
                '}';
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

    public Chapter[] getChapters() {
        return chapters;
    }

    public void setChapters(Chapter[] chapters) {
        this.chapters = chapters;
    }
}
