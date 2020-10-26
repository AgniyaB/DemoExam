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
    private static final Path LIB_PATH = Paths.get("lib.txt");

    private String title;
    private List<Book> books = new ArrayList<>();

    public Library(String title) {
        this.title = title;
    }

    public Library() {
    }

    public void save() throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(LIB_PATH))
        {
            StringBuilder sb = new StringBuilder();

            sb.append(title).append('\n');
            for(Book b : books) {
                sb.append(b.getId()).append(';')
                        .append(b.getTitle()).append(';')
                        .append(b.getAuthor()).append('\n');
            }

            bw.write(sb.toString());
        }
    }

    public void load() throws Exception {
        try (BufferedReader br = Files.newBufferedReader(LIB_PATH))
        {
            title = br.readLine();
            String temp;
            while((temp = br.readLine()) != null) {
                String[] arr = temp.split(";");
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
