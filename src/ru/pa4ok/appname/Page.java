package ru.pa4ok.appname;

import java.util.Arrays;

public class Page
{
    private int number;
    private String[] words;

    public Page(int number, String[] words) {
        this.number = number;
        this.words = words;
    }

    //второй конструктор вызывает первый
    public Page(int number) {
        this(number, new String[4]);
    }

    @Override
    public String toString() {
        return "Page{" +
                "number=" + number +
                ", words=" + Arrays.toString(words) +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }
}
