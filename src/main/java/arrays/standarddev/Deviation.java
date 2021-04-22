package arrays.standarddev;

public class Deviation {


    public double standardDeviation(double[] numberArray) {
        double avg = getAverageFromArray(numberArray);
        double count = 0.0;
        for (double actualDouble : numberArray) {
            count += Math.pow(actualDouble - avg, 2);
        }
        return Math.sqrt(count / (numberArray.length - 1));
    }


    private double getAverageFromArray(double[] numberArray) {
        double count = 0.0;
        for (double actualDouble : numberArray) {
            count += actualDouble;
        }
        return count / (numberArray.length);
    }
}
