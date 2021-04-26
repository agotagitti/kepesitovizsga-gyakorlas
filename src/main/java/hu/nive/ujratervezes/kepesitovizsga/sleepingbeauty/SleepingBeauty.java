package hu.nive.ujratervezes.kepesitovizsga.sleepingbeauty;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class SleepingBeauty {

    public Map<Character, Integer> countCharacters(String file) {
        Path path = Path.of("src/main/resources/" + file);
        try(BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            Map<Character, Integer> characterCount = new HashMap<>();
            while ((line = br.readLine()) != null) {
                char[] lineData = line.toLowerCase().toCharArray();
                getCharCount(characterCount, lineData);
            }
            return characterCount;
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot load file", ioe);
        }
    }

    private void getCharCount(Map<Character, Integer> characterCount, char[] lineData) {
        for (char actualChar : lineData) {
            if (Character.isLetter(actualChar)) {
                if (!characterCount.containsKey(actualChar)) {
                    characterCount.put(actualChar, 0);
                }
                characterCount.put(actualChar, characterCount.get(actualChar) + 1);
            }
        }
    }


}
