package com.textgame.gameloop;

import com.textgame.character.enemy.Bandit;
import com.textgame.character.enemy.Enemy;
import com.textgame.character.enemy.Goblin;
import com.textgame.character.enemy.Slime;

import java.util.ArrayList;

public class Area {
    private String name;
    private ArrayList<Area> linkedAreas;
    private float encounterChance;
    private ArrayList<Enemy> enemies;

    public Area(String name, float encounterChance) {
        this.name = name;
        this.linkedAreas = new ArrayList<>();
        this.encounterChance = encounterChance;
        this.enemies = new ArrayList<>();
    }

    public void setLinkedAreas(Area area) {
        this.linkedAreas.add(area);
    }

    public static void linkAreas(Area area1, Area area2) {
        area1.setLinkedAreas(area2);
        area2.setLinkedAreas(area1);
    }

    public ArrayList<Area> getLinkedAreas() {
        return this.linkedAreas;
    }

    public float getEncounterChance() {
        return encounterChance;
    }

    public void addEnemy(Enemy enemy) {
        this.enemies.add(enemy);
    }

    public Enemy getEnemy() {
        if (enemies.size() == 0) return  null;
        else return enemies.remove(0);
    }

    public static Area createWorld() {

        Area home = new Area("home", 0f);
        Area town = new Area("town", 0f);
        Area forest = new Area("forest", 1f);
        Area temple = new Area("temple", .1f);
        Area mountain = new Area("mountain", .7f);
        Area caves = new Area("caves", .5f);
        Area lostMines = new Area("lost mines", .9f);
        Area banditCamp = new Area("bandit camp", .9f);
        Area dragonLair = new Area("dragon lair", 1f);

        Area.linkAreas(home, forest);
        Area.linkAreas(home, town);
        Area.linkAreas(town, forest);
        Area.linkAreas(town, temple);
        Area.linkAreas(forest, caves);
        Area.linkAreas(town, mountain);
        Area.linkAreas(caves, lostMines);
        Area.linkAreas(forest, banditCamp);
        Area.linkAreas(mountain, dragonLair);
        Area.linkAreas(lostMines, mountain);

        forest.addEnemy(Goblin.spawn(1, forest));
        forest.addEnemy(Goblin.spawn(2, forest));
        forest.addEnemy(Slime.spawn(1, forest));
        forest.addEnemy(Slime.spawn(1, forest));
        forest.addEnemy(Bandit.spawn(1, forest));

        banditCamp.addEnemy(Bandit.spawn(3, banditCamp));
        banditCamp.addEnemy(Bandit.spawn(3, banditCamp));
        banditCamp.addEnemy(Bandit.spawn(2, banditCamp));
        banditCamp.addEnemy(Bandit.spawn(2, banditCamp));
        banditCamp.addEnemy(Bandit.spawn(1, banditCamp));

        mountain.addEnemy(Slime.spawn(3, mountain));
        mountain.addEnemy(Goblin.spawn(3, mountain));
        mountain.addEnemy(Goblin.spawn(3, mountain));
        mountain.addEnemy(Goblin.spawn(3, mountain));
        mountain.addEnemy(Bandit.spawn(3, mountain));

        caves.addEnemy(Slime.spawn(1, caves));
        caves.addEnemy(Slime.spawn(2, caves));
        caves.addEnemy(Slime.spawn(3, caves));
        caves.addEnemy(Slime.spawn(2, caves));
        caves.addEnemy(Slime.spawn(1, caves));

        return home;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
