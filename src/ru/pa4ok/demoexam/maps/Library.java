package ru.pa4ok.demoexam.maps;

import java.util.HashMap;
import java.util.Map;

public class Library
{
    private Map<Integer, Book> books = new HashMap<>();

    public Library() {
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<Integer, Book> books) {
        this.books = books;
    }
}
