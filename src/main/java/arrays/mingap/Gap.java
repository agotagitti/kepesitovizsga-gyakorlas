package arrays.mingap;

public class Gap {


    public int minGap(int[] numberArray) {
        if (numberArray.length < 2) {
            return 0;
        }
        int maxDifference = Integer.MAX_VALUE;
        for (int i = numberArray.length - 1; i > 0; i--) {
            if (numberArray[i] - numberArray[i -1] < maxDifference) {
                maxDifference = numberArray[i] - numberArray[i -1];
            }
        }
        return maxDifference;
    }
}
