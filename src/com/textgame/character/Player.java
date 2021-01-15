package com.textgame.character;

import com.textgame.gameloop.Area;
import com.textgame.item.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Character {

    private int maxHp;
    private int maxMp;
    private int xp;

    public Player(Area area) {
        super("player", 1, 100, 100, 10, 10, null, new ArrayList<>(), area, null);
        this.maxHp = this.hp;
        this.maxMp = this.mp;
        this.xp = 0;
    }

    public Item equipPlayer(Item equip) {
        this.equip = equip;
        return this.equip;
    }

    public void unequipPlayer() {
        this.inventory.add(this.equip);
        this.equip = null;
    }

    public void getXp(int xp) {
        this.xp += xp;
        System.out.println("Total xp is " + this.xp);
        if (this.xp > this.lvl*150) {
            System.out.println("Level up!");
            levelUp();
        }
    }

    public void addItem(Item item) {
        this.inventory.add(item);
    }

    private void levelUp() {
        this.lvl++;
        System.out.println("Choose 3 stats to raise: \n1.HP\n2.MP\n3.STR\n4.WIS");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++){
            switch (scanner.nextInt()) {
                case 1:
                    this.hp += 20;
                    System.out.println("HP is now " + this.hp);
                    break;
                case 2:
                    this.mp += 20;
                    System.out.println("MP is now " + this.mp);
                    break;
                case 3:
                    this.str += 1;
                    System.out.println("STR is now " + this.str);
                    break;
                case 4:
                    this.wis += 1;
                    System.out.println("WIS is now " + this.wis);
                    break;
            }
            this.hp = this.maxHp;
            this.mp = this.maxMp;
        }

    }

    @Override
    public int dmgCalc() {
        return this.str + this.wis/4;
    }

    public int special() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Fury Slash - Send a fury of attacks towards the enemy \nCost: 10MP" +
                "\n2.Magic Blast - Cast a basic magic blast spell \nCost: 15MP " +
                "\n3.Heal - Use a healing spell on yourself \nCost: 25MP");
        switch (scanner.nextInt()) {
            case 1:
                this.mp -= 10;
                return this.str * 5/3;
            case 2:
                this.mp -= 15;
                return this.wis*5/2;
            case 3:
                this.mp -= 25;
                this.hp += wis*2;
                return 0;
            default:
                return -1;
        }
    }
}
