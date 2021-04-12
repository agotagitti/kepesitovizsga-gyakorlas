package hu.nive.ujratervezes.kepesitovizsga.dogs;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class DogManager {

    List<Dog> dogs = new ArrayList<>();

    public DogManager() {
        readDogsFromFile();
    }

    public String getCountryByExactDogSpecies(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        for (Dog actualDog : dogs) {
            if (actualDog.getName().equals(name)) {
                return actualDog.getCountry();
            }
        }
        throw new IllegalArgumentException("No such dog name found.");
    }

    private void readDogsFromFile() {
        Path path = Path.of("src/main/resources/dogs.csv");
        try(BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            br.readLine();
            while((line = br.readLine()) != null) {
                processLineData(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot load file", ioe);
        }
    }

    private void processLineData(String line) {
        String[] dogData = line.split(";");
        String name = dogData[1];
        String country = dogData[4];
        String url = dogData[5];
        dogs.add(new Dog(name, country, url));
    }

    public List<Dog> getDogsInAlphabeticalOrderByName() {
        List<Dog> dogList = new ArrayList<>(dogs);
        Collections.sort(dogList, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return dogList;
    }


    public Map<String, Integer> getDogStatistics() {
        Map<String, Integer> dogsByCountry = new HashMap<>();
        for (Dog actualDog : dogs) {
            if (!dogsByCountry.containsKey(actualDog.getCountry())) {
                dogsByCountry.put(actualDog.getCountry(), 1);
            } else {
                dogsByCountry.put(actualDog.getCountry(), dogsByCountry.get(actualDog.getCountry()) + 1);
            }
        }
        return dogsByCountry;
    }
}
