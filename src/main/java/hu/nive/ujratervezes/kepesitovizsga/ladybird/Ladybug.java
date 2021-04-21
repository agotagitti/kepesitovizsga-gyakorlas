package hu.nive.ujratervezes.kepesitovizsga.ladybird;

import java.util.Objects;

public class Ladybug {

    private String hungarian_name;
    private String latin_name;
    private String genus;
    private int number_of_points;

    public Ladybug(String hungarian_name, String latin_name, String genus, int number_of_points) {
        this.hungarian_name = hungarian_name;
        this.latin_name = latin_name;
        this.genus = genus;
        this.number_of_points = number_of_points;
    }

    @Override
    public String toString() {
        return "Ladybug{" +
                "hungarian_name='" + hungarian_name + '\'' +
                ", latin_name='" + latin_name + '\'' +
                ", genus='" + genus + '\'' +
                ", number_of_points=" + number_of_points +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladybug ladybug = (Ladybug) o;
        return number_of_points == ladybug.number_of_points && Objects.equals(hungarian_name, ladybug.hungarian_name) && Objects.equals(latin_name, ladybug.latin_name) && Objects.equals(genus, ladybug.genus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hungarian_name, latin_name, genus, number_of_points);
    }
}
