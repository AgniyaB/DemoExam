package ru.pa4ok.demoexam;

public class Building
{
    protected String adress;
    protected int flootCount;

    public Building(String adress, int flootCount) {
        this.adress = adress;
        this.flootCount = flootCount;
    }

    @Override
    public String toString() {
        return "Building{" +
                "adress='" + adress + '\'' +
                ", flootCount=" + flootCount +
                '}';
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getFlootCount() {
        return flootCount;
    }

    public void setFlootCount(int flootCount) {
        this.flootCount = flootCount;
    }
}
