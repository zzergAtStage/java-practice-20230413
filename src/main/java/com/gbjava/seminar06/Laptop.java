package com.gbjava.seminar06;

public class Laptop {
    private int ramSize;
    private double ssdSize;
    private final int id;

    Laptop(int ramSize, double ssdSize, int id, double price, String os) {
        this.ramSize = ramSize;
        this.ssdSize = ssdSize;
        this.id = id;
        this.price = price;
        this.os = os;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    private final double price;

    private String os;


    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public double getSsdSize() {
        return ssdSize;
    }

    public void setSsdSize(double ssdSize) {
        this.ssdSize = ssdSize;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", ramSize=" + ramSize +
                ", ssdSize=" + ssdSize +
                ", price=" + price +
                ", OS=" + os +
                '}';
    }
}
