package leetcode.increase;

import java.util.stream.IntStream;

public class Increase {
    public int increase(int numberA, int numberB) {
       int result = IntStream.range(0, numberB)
                .reduce(0, (left, right) -> left + numberA);
        System.out.println("Wynik mnożenia bez używania znaku mnożenia" + numberA + "*" + numberB + "=" + result);
        return result;
    }
}
