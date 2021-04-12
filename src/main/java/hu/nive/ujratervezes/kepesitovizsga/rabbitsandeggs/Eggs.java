package hu.nive.ujratervezes.kepesitovizsga.rabbitsandeggs;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Eggs {

    public Rabbit getRabbitWithMaxEggs() {
          List<Rabbit> rabbits = readRabbitsFromFile();
          Rabbit bestWorker = rabbits.get(0);
          for (Rabbit actualRabbit : rabbits) {
              if (actualRabbit.getEggs() > bestWorker.getEggs()) {
                  bestWorker = actualRabbit;
              }
          }
          return bestWorker;
    }

    private List<Rabbit> readRabbitsFromFile() {
        Path path = Path.of("src/main/resources/eggs.csv");
        List<Rabbit> rabbits = new ArrayList<>();
        try(BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineData = line.split(";");
                rabbits.add(new Rabbit(lineData[0], Integer.parseInt(lineData[1])));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
        return rabbits;
    }

}
