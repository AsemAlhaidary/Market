package com.asem.market;

public class FoodstuffsProducts {
    public Integer[] pictures = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four};

    public String[] productsNames = {"Rice Alroban", "Suger Alsaid", "Keen", "OIL"};

    public Float[] productsPrice = {500.0f, 800.0f, 1000.0f, 500.0f};

    public Integer[] quantities = {10, 20, 5, 15};

    public Integer[] production_Date = {200112, 210101, 200501, 210201}; // yymmdd

    public Integer[] expiration_Date = {240112, 230101, 240501, 240201}; // yymmdd

    public String[] capacities = {"5k", "20k", "50k", "20k"};

    public void addProduct(Integer picture, String name, Float price) {
        addPicture(picture);
        addProductName(name);
        addProductPrice(price);
    }

    private void addPicture(Integer picture) {
        int picSize = pictures.length;
        pictures[picSize] = picture;
    }

    private void addProductName(String name) {
        int nameSize = productsNames.length;
        productsNames[nameSize] = name;
    }

    private void addProductPrice(Float price) {
        int priceSize = productsPrice.length;
        productsPrice[priceSize] = price;
    }
}
