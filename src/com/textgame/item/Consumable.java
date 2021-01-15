package com.textgame.item;

public class Consumable extends Item {
    private int hp;
    private int mp;

    public Consumable(String name, String description, int hp, int mp) {
        super(name, description);
        this.hp = hp;
        this.mp = mp;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }
}
