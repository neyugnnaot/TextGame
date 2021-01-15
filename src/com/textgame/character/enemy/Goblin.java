package com.textgame.character.enemy;

import com.textgame.gameloop.Area;
import com.textgame.gameloop.Game;

public class Goblin extends Enemy {
    public Goblin(int lvl, int hp, int mp, int str, int wis, Area currentArea) {
        super("Goblin", lvl, hp, mp, str, wis, null, null, currentArea, null);
    }

    public static Enemy spawn(int level, Area area) {

        switch (level) {
            case 3: return new Goblin(3, 110, 10, 13, 5, area);
            case 2: return new Goblin(2, 100, 10, 10, 3, area);
            case 1:
            default: return new Goblin(1, 90, 10, 7, 3, area);
        }

    }

    @Override
    public int action() {
        float roll = Game.roll();
        if(roll > .9f) {
            System.out.println("Enemy critical hit");
            return this.str * 3 / 2;
        } else if (roll > .35f) {
            System.out.println("Enemy attacks");
            return this.str;
        } else {
            System.out.println("Enemy misses");
            return 0;
        }
    }
}
