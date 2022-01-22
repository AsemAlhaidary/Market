package com.asem.market;

public class Drinks extends Category {
    private String capacity;

    public Drinks(String name, float price, int quantity, int production_Date, int expiration_Date, String capacity) {
        super(name, price, quantity, production_Date, expiration_Date);
        this.capacity = capacity;
    }

    @Override
    public void setDetails(String details) {
        super.details = details;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public float getPrice() {
        return super.price;
    }

    @Override
    public int getQuantity() {
        return super.quantity;
    }

    @Override
    public String getDetails() {
        return null;
    }

    @Override
    public int getProduction_Date() {
        return super.production_Date;
    }

    @Override
    public int getExpiration_Date() {
        return super.expiration_Date;
    }

    @Override
    public int getReminingDate() {
        return 0;
    }

    @Override
    public void insertNames(String[] names) {

    }

    @Override
    public void insertPrice(float[] prices) {

    }

    @Override
    public void insertQuantities(int[] quantities) {

    }

    @Override
    public void insertProduction_Date(int[] production_Date) {

    }

    @Override
    public void insertExpiration_Date(int[] expiration_Date) {

    }

    @Override
    public void displayData() {

    }
}
 