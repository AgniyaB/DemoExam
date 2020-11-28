package ru.pa4ok.appname;

public class Book
{
    int id; //дефольтный доступен из текущего файла и файлов в 1 пакете с ним
    private String title; //доступен только в рамках этого файла
    public String author; //доступен везде
    protected String test = "!"; //доступен в рамках одного пакета и всех классах наследниках

    public Book(int id, String title, String author)
    {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override //анотация, указывает на то что метод переоределен, не обязательна
    public String toString() {
        return "ru.pa4ok.appname.Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
