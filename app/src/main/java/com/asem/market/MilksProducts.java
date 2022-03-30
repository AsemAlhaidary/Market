package com.asem.market;

public class MilksProducts {
    public Integer[] pictures = {R.drawable.one, R.drawable.two, R.drawable.three,
            R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.two, R.drawable.three};

    public String[] productsNames = {"Milks caw", "Cheese", "Alrbee milk", "Almomtaz milk", "Yamani milk",
            "Wasaba milk", "Yogurt", "Alhanaa milk", "Banana milk", "Dried milk"};

    public Float[] productsPrice = {400f, 800f, 300f, 500f, 350f, 250f, 450f, 850f, 550f, 600f};

    public Integer[] quantities = {10, 20, 5, 15, 7, 9, 20, 30, 47, 19};

    public Integer[] production_Date = {200112, 210101, 200501, 210201, 201101, 201201, 210101, 200515, 200401, 200201}; // yymmdd

    public Integer[] expiration_Date = {240112, 230101, 240501, 240201, 221101, 211201, 240101, 230515, 230502, 240203}; // yymmdd

    public String[] capacities = {"250g", "250g", "250g", "900g", "900g", "250g", "1000", "250g", "500g", "250g"};

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
