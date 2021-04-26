package hu.nive.ujratervezes.kepesitovizsga.cinderella;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Cinderella {

    private String[] wordsForSearch = {"Hamupipőke", "galamb", "királyfi", "mostoha", "cipő"};
    private int[] numbers = new int[wordsForSearch.length];



    public void readFromFile() {
        Path path = Path.of("src/main/resources/cinderella/cinderella.txt");
        try(BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while((line = br.readLine()) != null) {
                String[] lineData = line.toLowerCase().split(" ");
                search(lineData);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot load file", ioe);
        }
    }

    private void search(String[] lineData) {
        for(int i = 0; i < lineData.length; i++) {
            for(int j = 0; j < wordsForSearch.length; j++) {
                if(lineData[i].contains(wordsForSearch[j].toLowerCase())) {
                    numbers[j]++;
                }
            }
        }
    }

    public int[] getNumbers() {
        return numbers;
    }

    public Object[] getMax() {
        int maxCount = 0;
        String maxWord = null;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > maxCount) {
                maxCount = numbers[i];
                maxWord = wordsForSearch[i];
            }
        }
        return new Object[]{maxWord, maxCount};
    }
}
