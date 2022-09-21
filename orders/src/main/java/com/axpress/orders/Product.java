package com.axpress.orders;

public class Product {
    private int barcode;
    private String type;
    private double cost;
    private int offer;
    private int quantity;

    public Product() {
    }

    public Product(int barcode, String type, double cost, int offer, int quantity){
        this.barcode = barcode;
        this.type = type;
        this.cost = cost;
        this.offer = offer;
        this.quantity = quantity;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getOffer() {
        return offer;
    }

    public void setOffer(int offer) {
        this.offer = offer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product [barcode=" + barcode + ", type=" + type + ", cost=" + cost + ", offer=" + offer + ", quantity=" + quantity + "]";
    }    
}
