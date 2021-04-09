package hu.nive.ujratervezes.kepesitovizsga.numberofdigits;

public class NumberOfDigits {


    public int getNumberOfDigits(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("Number cannot be less than 1");
        }
        int counter = 0;
        for(int j = 1; j <= i; j++) {
            counter += (int) (Math.log10(j) + 1);
        }
        return counter;
    }
}
