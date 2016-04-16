package com.redknot.domain;

/**
 * Created by miaoyuqiao on 16/4/16.
 */
public class FractalItem {
    private String itemName;
    private int id;
    private int toWhere;

    public FractalItem(String itemName,
                       int id,
                       int toWhere) {
        this.itemName = itemName;
        this.id = id;
        this.toWhere = toWhere;
    }

    public String toString() {
        return this.itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getToWhere() {
        return toWhere;
    }

    public void setToWhere(int toWhere) {
        this.toWhere = toWhere;
    }
}
