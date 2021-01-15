package com.textgame.character.enemy;

import com.textgame.character.Character;
import com.textgame.character.Player;
import com.textgame.gameloop.Area;
import com.textgame.gameloop.Game;
import com.textgame.item.Item;

import java.util.ArrayList;

public class Enemy extends Character {

    public Enemy(String name, int lvl, int hp, int mp, int str, int wis, Item equip, ArrayList<Item> inventory, Area currentArea, Item drop) {
        super(name, lvl, hp, mp, str, wis, equip, inventory, currentArea, drop);
    }

    public Enemy(Area area) {
        super("Enemy", 1, 30, 10, 8, 8, null, null, area, null);
    }

    public void dropItem(Player player) {
        float roll = Game.roll();
        if (roll < (float)this.lvl/player.getLvl()) {
            player.addItem(this.drop);
        }
    }

    public int action() {
        //Four actions
        float roll = Game.roll();
        if(roll > .8f) {
            System.out.println("Enemy critical hit");
            return this.str * 2;
        } else if (roll > .5f) {
            System.out.println("Enemy attacks");
            return this.str;
        } else if (roll > .25f) {
            System.out.println("Enemy attacks");
            return this.str + 1;
        } else {
            System.out.println("Enemy misses");
            return 0;
        }
    }

    public static Enemy spawn(int level, Area area) {
        return new Enemy(area);
    }

}
