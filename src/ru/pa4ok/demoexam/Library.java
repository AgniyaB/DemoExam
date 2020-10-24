package ru.pa4ok.demoexam;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Library
{
    private static final Path PATH = Paths.get("lib.txt");

    private String title;
    private List<Book> books = new ArrayList<>();

    public Library(String title) {
        this.title = title;
    }

    public Library() {
    }

    public void save() throws IOException {
        try(BufferedWriter bw = Files.newBufferedWriter(PATH))
        {
            bw.write(title);
            bw.newLine();
            for(Book b : books) {
                bw.write(Book.serialize(b));
                bw.newLine();
            }
        }
    }

    public void load() throws Exception
    {
        boolean markFirst = false;

        for(String s : Files.readAllLines(PATH))
        {
            if(!markFirst) {
                title = s;
                markFirst = true;
                continue;
            }

            Book book = Book.deserialize(s);
            if(book != null) {
                books.add(book);
            }
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
