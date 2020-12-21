package org.orgname.app.database.entity;

import javax.swing.*;
import java.util.Date;
import java.util.Random;

public class ClientEntity
{
    private int id;
    private String firstname;
    private String lastname;
    private String patronymic;
    private Date birthday;
    private Date register;
    private String email;
    private String phone;
    private char genderCode;
    private String photoPath;
    private Boolean markBoolean = new Random().nextBoolean();
    private ImageIcon icon;

    public ClientEntity(int id, String firstname, String lastname, String patronymic, Date birthday, Date register, String email, String phone, char genderCode, String photoPath) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.register = register;
        this.email = email;
        this.phone = phone;
        this.genderCode = genderCode;
        this.photoPath = photoPath;
    }

    public ClientEntity(String firstname, String lastname, String patronymic, Date birthday, Date register, String email, String phone, char genderCode, String photoPath) {
        this(-1, firstname, lastname, patronymic, birthday, register, email, phone, genderCode, photoPath);
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", register=" + register +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", genderCode=" + genderCode +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public ClientEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public ClientEntity setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public ClientEntity setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public ClientEntity setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public ClientEntity setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public Date getRegister() {
        return register;
    }

    public ClientEntity setRegister(Date register) {
        this.register = register;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ClientEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ClientEntity setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public char getGenderCode() {
        return genderCode;
    }

    public ClientEntity setGenderCode(char genderCode) {
        this.genderCode = genderCode;
        return this;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public ClientEntity setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
        return this;
    }
}
