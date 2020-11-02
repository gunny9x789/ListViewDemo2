package com.example.ad41_daongochai_listviewdemo2;

public class ItemOrder {
    private String nameItem;
    private int priceItem;

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public int getPriceItem() {
        return priceItem;
    }

    public void setPriceItem(int priceItem) {
        this.priceItem = priceItem;
    }

    public ItemOrder(String nameItem, int priceItem) {
        this.nameItem = nameItem;
        this.priceItem = priceItem;
    }
}
