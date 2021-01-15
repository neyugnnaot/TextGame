package com.textgame.character.enemy;

import com.textgame.gameloop.Area;
import com.textgame.gameloop.Game;

public class Bandit extends Enemy {
    public Bandit(int lvl, int hp, int mp, int str, int wis, Area currentArea) {
        super("Bandit", lvl, hp, mp, str, wis, null, null, currentArea, null);
    }

    public static Enemy spawn(int level, Area area) {

        switch (level) {
            case 3: return new Bandit(3, 140, 10, 16, 5, area);
            case 2: return new Bandit(2, 120, 10, 13, 4, area);
            case 1:
            default: return new Bandit(1, 100, 10, 10, 3, area);
        }

    }

    @Override
    public int action(){
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

}
