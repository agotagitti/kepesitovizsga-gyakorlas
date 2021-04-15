package hu.nive.ujratervezes.kepesitovizsga.uppercase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpperCaseLetters {

    public int getNumberOfUpperCase(String filename) {
        int countUpperCase = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(UpperCaseLetters.class.getResourceAsStream(filename)))) {
            String line;
            while ((line = br.readLine()) != null) {
                countUpperCase = getCount(countUpperCase, line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot load file", ioe);
        }
        return countUpperCase;
    }

    private int getCount(int countUpperCase, String line) {
        for (char actualChar : line.toCharArray()) {
            if (Character.isUpperCase(actualChar)) {
                countUpperCase++;
            }
        }
        return countUpperCase;
    }


}
