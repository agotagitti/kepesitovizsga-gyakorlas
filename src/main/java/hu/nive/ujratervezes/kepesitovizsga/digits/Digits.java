package hu.nive.ujratervezes.kepesitovizsga.digits;

public class Digits {

    public int getNumbers() {
        int countNumbers = 0;
        for (int i = 10; i <= 99; i++) {
            countNumbers += processNumber(i);
        }
        return countNumbers;
    }

    private int processNumber(int i) {
        int countNumbers = 0;
        int secondNumber = i % 10;
        int firstNumber = i / 10;
        if (firstNumber - secondNumber == 5 || secondNumber - firstNumber == 5) {
                countNumbers++;
        }
        return countNumbers;
    }
}
