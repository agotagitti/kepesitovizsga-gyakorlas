package hu.nive.ujratervezes.kepesitovizsga.littleredridinghood;

import java.util.Objects;

public class Hunter extends Forest{

    private String name;

    public Hunter(String name) {
        this.name = name;
    }

    @Override
    void eat() {
        Forest.playersOfTheTale.remove(new Wolf("Farkas"));
        Forest.playersOfTheTale.add(new Grandma("Nagymama"));
        Forest.playersOfTheTale.add(new LittleRedRidingHood("Piroska"));
        LittleRedRidingHood.shareCake(3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hunter hunter = (Hunter) o;
        return name.equals(hunter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
