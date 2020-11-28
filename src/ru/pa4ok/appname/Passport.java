package ru.pa4ok.appname;

public class Passport
{
    private int batch;
    private int number;
    private String address;

    public Passport(int batch, int number, String address) {
        this.batch = batch;
        this.number = number;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "batch=" + batch +
                ", number=" + number +
                ", address='" + address + '\'' +
                '}';
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
