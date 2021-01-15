package com.textgame.gameloop;

import com.textgame.character.Player;
import com.textgame.item.Item;

import java.util.ArrayList;

public class Commands {

    public static Area travel(Player player) {
        Area currentArea = player.getCurrentArea();
        ArrayList<Area> linkedAreas = currentArea.getLinkedAreas();
        System.out.println("Choose a place to travel to.");
        int count = 1;
        for (Area area:
             linkedAreas) {
            System.out.printf("%d: %s\n", count++, area);
        }
        int input = Listener.getInput();
        if (input > linkedAreas.size()){
            return currentArea;
        }
        Area newArea = linkedAreas.get(input-1);
        System.out.printf("Going to %s\n", newArea);
        player.setCurrentArea(newArea);
        if (Game.roll() < newArea.getEncounterChance()) {
            Battle.battleStart(player, newArea.getEnemy());
        }
        return newArea;
    }

    public static void explore(Player player) {
        float roll = Game.roll();
        if (roll < player.getCurrentArea().getEncounterChance()) {
            Battle.battleStart(player, player.getCurrentArea().getEnemy());
        }
    }

    public static void inventory(Player player) {
        for (Item x: player.getInventory()) {
            System.out.println(x);
        }
    }
}
