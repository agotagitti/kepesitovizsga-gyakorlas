package arrays.countinrange;

public class CountInRange {

    public int countInRange(int[] numberArray, int min, int max) {
        int counted = 0;
        for (int actualInt : numberArray) {
            if (actualInt > min && actualInt < max) {
                counted++;
            }
        }
        return counted;
    }
}
