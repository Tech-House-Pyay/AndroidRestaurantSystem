package com.example.foodordering.models;

public class ItemInfo {
    public int itemImage;
    public int itemPrice;
    public String itemName;
    public ItemInfo(int itemImage, String itemName, int itemPrice) {
        this.itemImage = itemImage;
        this.itemName = itemName;
        this.itemPrice = itemPrice;

    }
}
