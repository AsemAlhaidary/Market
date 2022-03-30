package com.asem.market;

public class ChocolatesProducts {
    public Integer[] pictures = {R.drawable.one, R.drawable.two, R.drawable.three,
            R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.two, R.drawable.three,
            R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.two, R.drawable.three};

    public String[] productsNames = {"Miro", "Furi", "Snikeras", "Younkers", "Roxy", "Rizo Break",
            "Break", "Sendebad", "Mars", "KetKat", "Big Break", "Team Up", "Tofy Luck", "Have Time"};

    public Float[] productsPrice = {200f, 250f, 700f, 300f, 200f, 300f, 300f, 100f, 700f, 700f,
            300f, 150f, 250f, 350f};

    public Integer[] quantities = {20, 30, 50, 60, 35, 40, 120, 240, 70, 80, 110, 60, 46, 50};

    public Integer[] production_Date = {220109, 210911, 210809, 211205, 210615, 210426, 211021,
            210729, 220103, 211023, 210912, 211026, 211106, 220103}; // yymmdd

    public Integer[] expiration_Date = {230510, 221012, 221110, 221206, 221115, 220428, 230121,
            230121, 230313, 221224, 230227, 221107, 230108, 221217}; // yymmdd

    public String[] capacities = {"250g", "250g", "250g", "900g", "900g", "250g", "1000", "250g"};

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
