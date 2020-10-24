package ru.pa4ok.demoexam.type;

public abstract class Button implements IOperational
{
    protected String title;

    public Button(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ru.pa4ok.demoexam.type.Button{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
