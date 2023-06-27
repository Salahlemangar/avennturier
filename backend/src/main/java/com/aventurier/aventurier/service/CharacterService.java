package com.aventurier.aventurier.service;

import com.aventurier.aventurier.model.Coordinate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CharacterService {

    private static final char WOOD_SYMBOL = '#';

    @Value("${filepath}")
    private  String FILE_PATH;
    private char[][] map;

    @PostConstruct
    private void init() {
        loadMapFromFile(FILE_PATH);
    }

    public Coordinate moveCharacter(Coordinate initialCoordinates, String movements) {
        int x = initialCoordinates.getX();
        int y = initialCoordinates.getY();
        int lastValidX = x;
        int lastValidY = y;

        for (char movement : movements.toCharArray()) {
            int newX = x;
            int newY = y;

            switch (movement) {
                case 'N':
                    newY--;
                    break;
                case 'S':
                    newY++;
                    break;
                case 'E':
                    newX++;
                    break;
                case 'O':
                    newX--;
                    break;
                default:
                    // Ignore unknown movement characters
                    break;
            }

            if (isValidMove(newX, newY)) {
                x = newX;
                y = newY;
                lastValidX = x;
                lastValidY = y;
            }
        }

        return new Coordinate(lastValidX, lastValidY);
    }

    private void loadMapFromFile(String filename) {
        try {
            File file = new File(filename);
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            List<String> lines = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

            int height = lines.size();
            int width = lines.get(0).length();

            map = new char[height][width];
            for (int i = 0; i < height; i++) {
                String currentLine = lines.get(i);
                for (int j = 0; j < width; j++) {
                    map[i][j] = currentLine.charAt(j);
                }
            }

            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private boolean isValidMove(int x, int y) {
        if (x < 0 || y < 0 || x >= map.length || y >= map[x].length) {
            // If the movement goes beyond the map boundaries, generate a random map and continue
            generateRandomMap();
            return true;
        }
        return !isWood(x, y);
    }

    private void generateRandomMap() {
        // Generate a new random map with the same dimensions as the original map
        Random random = new Random();
        map = new char[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = random.nextBoolean() ? ' ' : WOOD_SYMBOL;
            }
        }
    }

    private boolean isWood(int x, int y) {
        return map[y][x] == WOOD_SYMBOL;
    }
}
