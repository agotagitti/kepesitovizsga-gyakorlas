package temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {

    public Temperatures readTemperatures(String pathString) {
        Path path = Path.of(pathString);
        try {
            byte[] tempdata = Files.readAllBytes(path);
                return new Temperatures(tempdata);

        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read database", ioe);
        }
    }

}
