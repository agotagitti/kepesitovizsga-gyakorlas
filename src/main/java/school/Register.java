package school;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Register {


    public void newMark(Path studentFile, int mark) {
        try {
            if (Files.exists(studentFile)) {
                Files.writeString(studentFile, mark + "\n", StandardOpenOption.APPEND);
            } else {
                Files.writeString(studentFile, String.valueOf(mark));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }

    public void average(Path studentFile) {
        try {
            List<String> marksFromFile = Files.readAllLines(studentFile);
            double result = 0.0;
            for (String actualMark : marksFromFile) {
                result += Double.parseDouble(actualMark);
            }
            result /= marksFromFile.size();
            Files.writeString(studentFile, "average: " + result, StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }
}
