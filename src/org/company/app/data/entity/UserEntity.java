package org.company.app.data.entity;

import org.company.app.data.GenderEnum;

public class UserEntity
{
    private int id;
    private String login;
    private String password;
    private GenderEnum gender;
    private int age;
    private String job;
    private String notes;
    private Boolean markBoolean = true;

    public UserEntity(int id, String login, String password, GenderEnum gender, int age, String job, String notes) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.job = job;
        this.notes = (notes == null ? "" : notes);
    }

    public UserEntity(String login, String password, GenderEnum gender, int age, String job, String notes) {
        this(-1, login, password, gender, age, job, notes);
    }

    public static boolean isLoginInCorrect(String login) {
        return login.length() > 20;
    }

    public static boolean isPasswordInCorrect(String pass) {
        return pass.length() > 32;
    }

    public static boolean isAgeInCorrect(String ageString) {
        try {
            int age = Integer.parseInt(ageString);
            return age <= 0;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean isJobInCorrect(String job)
    {
        return job.length() > 45;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", notes='" + notes + '\'' +
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

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
