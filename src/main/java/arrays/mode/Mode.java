package arrays.mode;

import java.util.HashMap;
import java.util.Map;

public class Mode {


    public int mode(int[] numberArray) {
        Map<Integer, Integer> countNumbers = getMapFromArray(numberArray);
        int result = 0;
        int count = 0;
        for (Map.Entry<Integer, Integer> actualEntry : countNumbers.entrySet()) {
            if (actualEntry.getValue() > count) {
                result = actualEntry.getKey();
            }
        }
        return result;
    }

    private Map<Integer, Integer> getMapFromArray(int[] numberArray) {
        Map<Integer, Integer> countNumbers = new HashMap<>();
        for (int actualInt : numberArray) {
            if (actualInt >= 0 && actualInt <= 100) {
                if (countNumbers.containsKey(actualInt)) {
                    countNumbers.put(actualInt, countNumbers.get(actualInt) + 1);
                } else {
                    countNumbers.put(actualInt, 1);
                }
            } else {
                throw new IllegalArgumentException("Invalid number");
            }
        }
        return countNumbers;
    }
}
