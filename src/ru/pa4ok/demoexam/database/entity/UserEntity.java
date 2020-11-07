package ru.pa4ok.demoexam.database.entity;

public class UserEntity
{
    private long id;
    private String login;
    private String password;

    public UserEntity(long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public UserEntity(String login, String password)
    {
        this(-1, login, password);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
