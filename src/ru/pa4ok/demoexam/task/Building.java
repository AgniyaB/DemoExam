package ru.pa4ok.demoexam.task;

public class Building
{
    protected String adress;
    protected int floorCount;

    public Building(String adress, int floorCount) {
        this.adress = adress;
        this.floorCount = floorCount;
    }

    @Override
    public String toString() {
        return "Building{" +
                "adress='" + adress + '\'' +
                ", floorCount=" + floorCount +
                '}';
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }
}
