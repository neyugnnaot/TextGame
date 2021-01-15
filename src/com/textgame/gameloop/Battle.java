package com.textgame.gameloop;

import com.textgame.character.enemy.Enemy;
import com.textgame.character.Player;

public class Battle {

    private static final int ATTACK = 1;
    private static final int SPECIAL = 2;
    private static final int DEFEND = 3;
    private static final int ITEM = 4;
    private static final int FLEE = 5;

    private static boolean flee = false;
    private static boolean reduceDmg = false;

    public static void battleStart(Player player, Enemy enemy) {

        int xp = enemy.getHp() * 4 / 3;
        while(!player.isDead() && !flee) {

            System.out.println("You encounted a " + enemy.getName());
            System.out.printf("Player HP: %d\n%s HP: %d\n", player.getHp(), enemy.getName(), enemy.getHp());

            int playerAction = playerAction(player);
            enemy.takeDamage(playerAction);
            if(enemy.isDead()) {
                System.out.println("Defeated the " + enemy.getName());
                System.out.printf("Gained %dxp\n", xp);
                player.getXp(xp);
                enemy.dropItem(player);
                break;
            }

            int dmgTaken = 0;
            int enemyAction = enemy.action();
            if(reduceDmg) {
                reduceDmg = false;
                dmgTaken = player.takeDamage(enemyAction, 2);
            } else {
                dmgTaken = player.takeDamage(enemyAction);
            }
            System.out.printf("You take %d damage\n", dmgTaken);
            if(player.isDead()){
                System.out.println("YOU DIED");
                Game.setGamestate(Game.GAMEOVER);
            }
        }
        if(flee) {
            System.out.println("You have fled");
        }

    }

    public static int playerAction(Player player) {

        System.out.println("1. ATTACK\n2. SPECIAL\n3. DEFEND\n4. ITEM\n5. FLEE");
        int input = Listener.getInput();
        int retVal = 0;
        switch (input) {
            case ATTACK:
                retVal = player.dmgCalc();
                System.out.printf("You attack for %d damage\n", retVal);
                break;
            case SPECIAL:
                retVal = player.special();
                System.out.printf("You use special attack for %d damage\n", retVal);
                break;
            case DEFEND:
                System.out.println("You defended against the enemy");
                reduceDmg = true;
                break;
            case ITEM:
                System.out.println("You used an item");
                player.useItem();
                break;
            case FLEE:
                if (Game.roll() > 0.5f) flee = true;
        }

        return retVal;
    }

}
