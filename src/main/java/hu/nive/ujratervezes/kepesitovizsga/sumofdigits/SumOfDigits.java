package hu.nive.ujratervezes.kepesitovizsga.sumofdigits;

import java.util.Random;

public class SumOfDigits {


    public int getSumOfDigits(Random random) {
        int number = Math.abs(random.nextInt());
        while (number > 9) {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            number = sum;
        }
        return number;
    }

}
