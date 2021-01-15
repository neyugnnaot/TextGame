package com.textgame.character.enemy;

import com.textgame.gameloop.Area;
import com.textgame.gameloop.Game;

public class Slime extends Enemy {

    public Slime(int lvl, int hp, int mp, int str, int wis, Area currentArea) {
        super("Slime", lvl, hp, mp, str, wis, null, null, currentArea, null);
    }

    public static Enemy spawn(int level, Area area) {

        switch (level) {
            //Use JSONs to spawn
            case 3: return new Slime(3, 90, 50, 6, 11, area);
            case 2: return new Slime(2, 80, 40, 5, 9, area);
            case 1:
            default: return new Slime(1, 70, 30, 4, 8, area);
        }

    }

    @Override
    public int action() {
        float roll = Game.roll();
        if(roll > .85f) {
            System.out.println("Enemy critical hit");
            return this.str * 5 / 3;
        } else if (roll > .15f) {
            System.out.println("Enemy attacks");
            return this.str;
        } else {
            System.out.println("Enemy misses");
            return 0;
        }
    }
}
