package leetcode.increase;

public class Increase {
    public int increase(int numberA, int numberB, int result) {
        for (int i = 0; i < numberB; i++) {
            result += numberA;
        }
        System.out.println("Wynik mnożenia bez używania znaku mnożenia" + numberA + "*" + numberB + "=" + result);
        return result;
    }
}
