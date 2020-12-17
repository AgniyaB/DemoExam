package org.company.app.data.entity;

public class ServiceEntity
{
    private int id;
    private String title;
    private double cost;
    private int duration;
    private String description;
    private double discount;
    private String impPath;

    public ServiceEntity(int id, String title, double cost, int duration, String description, double discount, String impPath) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.duration = duration;
        this.description = description;
        this.discount = discount;
        this.impPath = impPath;
    }

    public ServiceEntity(String title, double cost, int duration, String description, double discount, String impPath) {
        this(-1, title, cost, duration, description, discount, impPath);
    }

    @Override
    public String toString() {
        return "ServiceEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", impPath='" + impPath + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getImpPath() {
        return impPath;
    }

    public void setImpPath(String impPath) {
        this.impPath = impPath;
    }
}
