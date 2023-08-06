package leetcode.largeelement;

import java.util.Arrays;

public class Element {
    public int secondLargestElement(int[] array) {
        return Arrays.stream(array)
                .sorted()
                .skip(Math.max(0, array.length - 2)) //Math.max() zapewnia, że ilość elementów do pominięcia nie jest ujemna
                .findFirst()
                .orElse(Integer.MIN_VALUE);
    }
}
