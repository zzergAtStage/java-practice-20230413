package com.gbjava.seminar06;

public class Laptop {
    private final int ramSize;
    private final double ssdSize;
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

    private final double price;

    private final String os;


    public int getRamSize() {
        return ramSize;
    }

    public double getSsdSize() {
        return ssdSize;
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
