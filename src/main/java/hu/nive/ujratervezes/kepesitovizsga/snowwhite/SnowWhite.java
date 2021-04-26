package hu.nive.ujratervezes.kepesitovizsga.snowwhite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SnowWhite {

    List<Dwarf> sevenDwarfs;

    public SnowWhite(List<Dwarf> sevenDwarfs) {
        this.sevenDwarfs = sevenDwarfs;
    }

    public List<Dwarf> getSevenDwarfs() {
        return new ArrayList<>(sevenDwarfs);
    }

    public List<Dwarf> getSevenDwarfsOrderedByNames() {
        List<Dwarf> dwarfsByNames = new ArrayList<>();
        for (Dwarf actualDwarf : sevenDwarfs) {
            dwarfsByNames.add(actualDwarf);
        }
        Collections.sort(dwarfsByNames, new Comparator<Dwarf>() {
            @Override
            public int compare(Dwarf o1, Dwarf o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return dwarfsByNames;
    }

    public List<Dwarf> getSevenDwarfsOrderedByAges() {
        List<Dwarf> dwarfsByAges = new ArrayList<>();
        for (Dwarf actualDwarf : sevenDwarfs) {
            dwarfsByAges.add(actualDwarf);
        }
        Collections.sort(dwarfsByAges, new Comparator<Dwarf>() {
            @Override
            public int compare(Dwarf o1, Dwarf o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        return dwarfsByAges;
    }
}
