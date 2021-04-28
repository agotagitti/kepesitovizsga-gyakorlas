package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BandManager {

    private List<Band> bands = new ArrayList<>();

    public void readBandsFromFile(Path inputFile) {
        try (BufferedReader br = Files.newBufferedReader(inputFile)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineData = line.split(";");
                fillBandList(lineData);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }
    }

    private void fillBandList(String[] lineData) {
        String name = lineData[0];
        int year = Integer.parseInt(lineData[1]);
        bands.add(new Band(name, year));
    }


    public void writeBandsBefore(Path outputFile, int year) {
        try (BufferedWriter bw = Files.newBufferedWriter(outputFile)) {
            for (Band actualBand : bandsBefore(year)) {
                    bw.write(actualBand.getName() + " " + actualBand.getYear() + "\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }

    private List<Band> bandsBefore(int year) {
        List<Band> bandsBeforeYear = new ArrayList<>();
        for (Band actualBand : bands) {
            if (actualBand.getYear() < year) {
                bandsBeforeYear.add(actualBand);
            }
        }
        return bandsBeforeYear;
    }


    public List<Band> getBands() {
        return bands;
    }
}
