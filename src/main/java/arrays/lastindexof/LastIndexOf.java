package arrays.lastindexof;

public class LastIndexOf {


    public int lastIndexOf(int[] numberArray, int number) {
        int result = -1;
        for (int i = 0; i < numberArray.length; i++) {
            if (numberArray[i] == number) {
                result = i;
            }
        }
        return result;
    }
}
