package ru.pa4ok.demoexam.database.entity;

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

    public boolean validate()
    {
        if(login.length() > 20 || password.length() > 32 || age < 0 || job.length() > 45) {
            return false;
        }
        return true;
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

    public void setId(int id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
