package ru.pa4ok.demoexam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library implements Externalizable
{
    private String title;
    private List<Book> books;

    public Library(String title) {
        this.title = title;
        this.books = new ArrayList<>();
    }

    public Library() {}

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(title);
        out.writeObject(books);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title = (String) in.readObject();
        books = (List<Book>) in.readObject();
    }

    public static void save(Library library, String path) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(library);
        }
    }

    public static Library load(String path) throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (Library) ois.readObject();
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
