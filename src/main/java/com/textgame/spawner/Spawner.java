package com.textgame.spawner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.textgame.character.Character;

import java.io.File;
import java.io.IOException;

public class Spawner {
    public static boolean writeCharacter(Character character) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("JSON Files/Player.json"), character);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
