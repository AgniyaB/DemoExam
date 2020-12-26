package ru.pa4ok.appname.database.entity;

public class FilmEntity
{
    /*
    создать такую сущность и менеджер для работы с бд к ней
    продемонстрировать работу всех функций менеджера
     */

    private int id;
    private String title;
    private String author;
    private int budget;
    private double duration;

    public FilmEntity(int id, String title, String author, int budget, double duration) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.budget = budget;
        this.duration = duration;
    }

    public FilmEntity(String title, String author, int budget, double duration) {
        this(-1, title, author, budget, duration);
    }

    @Override
    public String toString() {
        return "FilmEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", budget=" + budget +
                ", duration=" + duration +
                '}';
    }

    public int getId() {
        return id;
    }

    public FilmEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public FilmEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public FilmEntity setAuthor(String author) {
        this.author = author;
        return this;
    }

    public int getBudget() {
        return budget;
    }

    public FilmEntity setBudget(int budget) {
        this.budget = budget;
        return this;
    }

    public double getDuration() {
        return duration;
    }

    public FilmEntity setDuration(double duration) {
        this.duration = duration;
        return this;
    }
}
