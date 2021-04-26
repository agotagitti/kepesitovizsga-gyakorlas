package hu.nive.ujratervezes.kepesitovizsga.littleredridinghood;

import java.util.Objects;

public class LittleRedRidingHood extends Forest{

    private String name;
    protected static int cake = 10;

    public LittleRedRidingHood(String name) {
        this.name = name;
    }

    @Override
    void eat() {
        cake -= 1;
    }

    public static void shareCake(int slice) {
        cake -= slice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LittleRedRidingHood that = (LittleRedRidingHood) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
