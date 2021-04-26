package hu.nive.ujratervezes.kepesitovizsga.littleredridinghood;

import java.util.Arrays;
import java.util.Objects;

public class Wolf extends Forest{

    private String name;

    public Wolf(String name) {
        this.name = name;
    }

    @Override
    void eat() {
        Forest.playersOfTheTale.remove(new Grandma("Nagymama"));
        Forest.playersOfTheTale.remove(new LittleRedRidingHood("Piroska"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wolf wolf = (Wolf) o;
        return name.equals(wolf.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
