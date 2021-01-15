package com.textgame.gameloop;

import com.textgame.character.Player;

import java.util.Scanner;

public class Listener {

    private static final int EXIT = -1;
    private static final int TRAVEL = 1;
    private static final int EXPLORE = 2;
    private static final int INVENTORY = 3;

    static Scanner scanner = new Scanner(System.in);

    public static int getInput() {
        return scanner.nextInt();
    }

    public static void getCommand(Player player) {

        boolean done = false;
        while(!done && !Game.over()) {
            System.out.printf("Currently at %s\n", player.getCurrentArea());
            System.out.println("What do you want to do?");

            int input = getInput();
            switch (input) {
                case TRAVEL:
                    Commands.travel(player);
                    break;
                case EXPLORE:
                    Commands.explore(player);
                    break;
                case INVENTORY:
                    Commands.inventory(player);
                    break;
                case EXIT:
                default:
                    System.out.println("No actions given");
                    done = true;
            }
        }
    }

}

