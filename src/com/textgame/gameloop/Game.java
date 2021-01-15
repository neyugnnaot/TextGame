package com.textgame.gameloop;

import com.textgame.character.Player;

import java.util.Random;

public class Game {

    public static final int GAMEOVER = 0;
    public static final int RUNNING = 1;

    static int gamestate = 1;

    public static float roll() {
        Random rng = new Random(System.currentTimeMillis());
        return rng.nextFloat()%1;
    }

    public static void setGamestate(int state) {
        gamestate = state;
    }

    public static boolean over() {
        if (gamestate == GAMEOVER) {
            System.out.println("GAME OVER");
            return true;
        }
        return false;
    }

    public static void start(){
//        GUI gui = new GUI();

        Player player = new Player(Area.createWorld());
        Listener.getCommand(player);

    }


}
