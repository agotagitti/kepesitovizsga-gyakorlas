package arrays.median;

import java.util.Arrays;

public class MedianFinder {


    public double median(int[] numberArray) {
        int[] numbersInOrder = new int[numberArray.length];
        for (int i = 0; i < numbersInOrder.length; i++) {
            numbersInOrder[i] = numberArray[i];
        }
        Arrays.sort(numbersInOrder);
        int temp = numbersInOrder.length / 2;
        if (numbersInOrder.length % 2 == 0) {
            return (numbersInOrder[temp] + numbersInOrder[temp - 1]) / 2.0;
        } else {
            return numbersInOrder[temp];
        }
    }
}
