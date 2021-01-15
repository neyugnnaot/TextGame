package com.textgame.item;

public class Item {
    private String name;
    private String description;

    public Item() {
        this.name = null;
        this.description = null;
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
