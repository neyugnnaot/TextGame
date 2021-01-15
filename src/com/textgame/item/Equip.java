package com.textgame.item;

import com.textgame.item.Item;

public class Equip extends Item {
    private int hp;
    private int mp;
    private int str;
    private int wis;

    public Equip(String name, String description, int hp, int mp, int str, int wis) {
        super(name, description);
        this.hp = hp;
        this.mp = mp;
        this.str = str;
        this.wis = wis;
    }
}
