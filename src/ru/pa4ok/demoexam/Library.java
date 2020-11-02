package ru.pa4ok.demoexam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Library
{
    private static final Path path = Paths.get("lib.txt");

    private String title;
    private List<Book> books = new ArrayList<>();

    public Library(String title) {
        this.title = title;
    }

    public Library() throws IOException {
        load();
    }

    public void save() throws IOException {
        try(BufferedWriter bw = Files.newBufferedWriter(path)) {
            bw.write(title);
            bw.newLine();
            for(Book b : books) {
                bw.write(b.getId() + ";" + b.getTitle() + ";" + b.getAuthor());
                bw.newLine();
            }
        }
    }

    public void load() throws IOException {
        try(BufferedReader br = Files.newBufferedReader(path)) {
            title = br.readLine();
            String s;
            while((s = br.readLine()) != null) {
                String[] arr = s.split(";");
                books.add(new Book(
                        Integer.parseInt(arr[0]),
                        arr[1],
                        arr[2]
                ));
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
