package hu.nive.ujratervezes.kepesitovizsga.littleredridinghood;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Forest {

    protected static List<Forest> playersOfTheTale = new ArrayList<>(Arrays.asList(new LittleRedRidingHood("Piroska"), new Wolf("Farkas"), new Grandma("Nagymama"), new Hunter("Vadász")));

    abstract void eat();
}
