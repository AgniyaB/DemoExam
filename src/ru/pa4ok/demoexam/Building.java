package ru.pa4ok.demoexam;

public class Building
{
    protected String address;
    protected int floorCount;
    protected BuildingTypeEnum buildingType;

    public Building(String address, int floorCount, BuildingTypeEnum buildingType) {
        this.address = address;
        this.floorCount = floorCount;
        this.buildingType = buildingType;
    }

    @Override
    public String toString() {
        return "Building{" +
                "address='" + address + '\'' +
                ", floorCount=" + floorCount +
                ", buildingType=" + buildingType +
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

    public BuildingTypeEnum getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingTypeEnum buildingType) {
        this.buildingType = buildingType;
    }
}
