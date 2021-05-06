package hu.nive.ujratervezes.kepesitovizsga.finelongword;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FineLongWord {


    public char[] readFineLongWordFromFileAndGetItInAnArray(String file) {
        Path path = Path.of("src/main/resources/" + file);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(path)) {
            sb.append(br.readLine());
            String line;
            while ((line = br.readLine()) != null) {
               String[] lineData = line.split("");
               sb.append(lineData[line.length() - 1]);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot load file", ioe);
        }
        return sb.toString().toCharArray();
    }
}
