package com.textgame.character;

import com.textgame.gameloop.Area;
import com.textgame.item.Consumable;
import com.textgame.item.Item;

import java.util.ArrayList;

public class Character {
    protected String name;
    protected int lvl;
    protected int hp;
    protected int mp;
    protected int str;
    protected int wis;
    protected Item equip;
    protected ArrayList<Item> inventory;
    protected Area currentArea;
    protected Item drop;

    public String getName() {
        return name;
    }

    public int getLvl() {
        return lvl;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getStr() {
        return str;
    }

    public int getWis() {
        return wis;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Item getDrop() {
        return this.drop;
    }

    public Character(String name, int lvl, int hp, int mp, int str, int wis, Item equip, ArrayList<Item> inventory, Area currentArea, Item drop) {
        this.name = name;
        this.lvl = lvl;
        this.hp = hp;
        this.mp = mp;
        this.str = str;
        this.wis = wis;
        this.equip = equip;
        this.inventory = inventory;
        this.currentArea = currentArea;
        this.drop = drop;
    }

    public void setCurrentArea(Area area) {
        this.currentArea = area;
    }
    public Area getCurrentArea() {
        return this.currentArea;
    }
    public int takeDamage(int dmg) {
        this.hp -= dmg;
        return dmg;
    }

    public int takeDamage(int dmg, int reduction) {
        int dmgTaken = dmg / reduction;
        this.hp -= dmgTaken;
        return dmgTaken;
    }
    public boolean isDead() {
        return !(this.hp > 0);
    }

    public int dmgCalc() {
        return this.str;
    }

    public void useItem() {
        this.hp += 10;
    }
}
