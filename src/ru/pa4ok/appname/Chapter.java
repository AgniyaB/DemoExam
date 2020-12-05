package ru.pa4ok.appname;

import java.util.Arrays;

public class Chapter
{
    private int number;
    private String title;
    private Page[] pages;

    public Chapter(int number, String title, Page[] pages) {
        this.number = number;
        this.title = title;
        this.pages = pages;
    }

    public Chapter(int number, String title) {
        this(number, title, new Page[2]);
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", pages=" + Arrays.toString(pages) +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Page[] getPages() {
        return pages;
    }

    public void setPages(Page[] pages) {
        this.pages = pages;
    }
}
