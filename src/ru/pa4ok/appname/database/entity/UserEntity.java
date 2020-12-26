package ru.pa4ok.appname.database.entity;

public class UserEntity
{
    private int id;
    private String login;
    private String password;
    private int age;
    private String job;

    public UserEntity(int id, String login, String password, int age, String job) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.age = age;
        this.job = job;
    }

    public UserEntity(String login, String password, int age, String job) {
        this(-1, login, password, age, job);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public UserEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UserEntity setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserEntity setAge(int age) {
        this.age = age;
        return this;
    }

    public String getJob() {
        return job;
    }

    public UserEntity setJob(String job) {
        this.job = job;
        return this;
    }
}
