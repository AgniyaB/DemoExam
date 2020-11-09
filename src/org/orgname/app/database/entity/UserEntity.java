package org.orgname.app.database.entity;

public class UserEntity
{
    private int id;
    private String login;
    private String pass;

    public UserEntity(int id, String login, String pass) {
        this.id = id;
        this.login = login;
        this.pass = pass;
    }

    public UserEntity(String login, String pass) {
        this(-1, login, pass);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
