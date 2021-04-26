package arrays.kthlargest;

import java.util.Arrays;

public class KthLargest {

    public int kthLargest(int[] numbers, int reference) {
        int[] numbersInOrder = new int[numbers.length];
        System.arraycopy(numbers, 0, numbersInOrder, 0, numbersInOrder.length);
        Arrays.sort(numbersInOrder);
        int index = numbersInOrder.length - 1 - reference;
        return numbersInOrder[index];
    }
}
