package hu.nive.ujratervezes.kepesitovizsga.littleredridinghood;

import java.util.Objects;

public class Grandma extends Forest{

    private String name;

    public Grandma(String name) {
        this.name = name;
    }

    @Override
    void eat() {
        LittleRedRidingHood.shareCake(2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grandma grandma = (Grandma) o;
        return name.equals(grandma.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
