package ru.pa4ok.demoexam;

public abstract class Building
{
    protected String address;
    protected int floorCount;
    protected BuildingType type;

    public Building(String address, int floorCount, BuildingType type) {
        this.address = address;
        this.floorCount = floorCount;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Building{" +
                "address='" + address + '\'' +
                ", floorCount=" + floorCount +
                ", type=" + type +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public BuildingType getType() {
        return type;
    }

    public void setType(BuildingType type) {
        this.type = type;
    }
}
