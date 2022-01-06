package com.asem.market;

import java.text.NumberFormat;

public class MainModel {
    Integer itemImage;
    String itemName;
    Float itemPrice;

    public MainModel(Integer itemImage, String itemName, Float itemPrice) {
        this.itemImage = itemImage;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public Integer getItemImage() {
        return itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemPrice() {
        return NumberFormat.getCurrencyInstance().format(itemPrice);
    }
}
