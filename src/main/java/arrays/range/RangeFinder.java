package arrays.range;

import java.util.Arrays;

public class RangeFinder {


    public static int range(int[] numberArray) {
        if (numberArray.length == 1) {
            return 1;
        }
        int[] numbers = numberArray;
        Arrays.sort(numbers);
        return numbers[numbers.length - 1] - numbers[0] + 1;
    }
}
