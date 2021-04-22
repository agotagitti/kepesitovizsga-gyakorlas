package arrays.issorted;

import java.util.Arrays;

public class Sorter {


    public static boolean isSorted(double[] numbers) {
        double[] tempNumbers = new double[numbers.length];
        System.arraycopy(numbers,0, tempNumbers, 0, numbers.length);
//        for (int i = 0; i < tempNumbers.length; i++) {
//            tempNumbers[i] = numbers[i];
//        }
        Arrays.sort(tempNumbers);
        if(Arrays.equals(tempNumbers, numbers)) {
            return true;
        }
        return false;
    }
}
