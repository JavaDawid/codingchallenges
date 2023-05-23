package leetcode.increase;

public class Increase {
    int result;

    public int increase(int numberA, int numberB) {
        int sign = 1;
        if ((numberA < 0 && numberB > 0) || (numberA > 0 && numberB < 0)) {
            sign = -1;
        }
        numberA = Math.abs(numberA);
        numberB = Math.abs(numberB);
        int result = 0;
        for (int i = 0; i < numberB; i++) {
            result += numberA;
        }
        return sign * result;
    }
}
