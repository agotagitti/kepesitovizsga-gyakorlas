package arrays.percenteven;

public class Evens {


    public double percentEven(int[] numberArray) {
        if (numberArray.length == 0) {
            return 0.0;
        }
        int countEven = 0;
        for (int actualInt : numberArray) {
            if (actualInt % 2 == 0) {
                countEven++;
            }
        }
        if (countEven == 0) {
            return countEven;
        }
        return countEven * 100.0 / numberArray.length;
    }
}
