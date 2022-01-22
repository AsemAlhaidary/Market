package com.asem.market;

public class DrinksProducts {
    public Integer[] pictures = {R.drawable.one, R.drawable.two, R.drawable.three,
            R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.two, R.drawable.three,
            R.drawable.four, R.drawable.five, R.drawable.six};

    public String[] productsNames = {"One", "Two", "Three", "Four", "Five", "Six", "Two", "Three", "Four", "Five", "Six"};

    public Float[] productsPrice = {32.0f, 32.0f, 44.0f, 21.0f, 65.0f, 43.0f, 32.0f, 44.0f, 21.0f, 65.0f, 43.0f};

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
