package arrays.isunique;

import java.util.HashSet;
import java.util.Set;

public class Unique {


    public boolean isUnique(int[] numberArray) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int actualInt : numberArray) {
            uniqueNumbers.add(actualInt);
        }
        return uniqueNumbers.size() == numberArray.length;
    }
}
