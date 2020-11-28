package ru.pa4ok.test;

public class Note
{
    /*
    принято помечать все поля private + делать для них геттеры и сеттеры
     */

    private int id;
    private String text;

    public Note(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
