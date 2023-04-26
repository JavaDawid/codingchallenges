package leetcode.largeelement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {
    @Test
    public void shouldGiveSecondLargestElement() {
        int[] array1 = {12, 15, 20, 100, 99, 10};
        int[] array2 = {-1, 0, -15, -2, 1};
        int[] array3 = {15, -15, 0, 20};
        int[] array4 = {100, -15, 0, 20};

        int result1 = 99;
        int result2 = 0;
        int result3 = 15;
        int result4 = 20;

        Element element = new Element();
        Assertions.assertEquals(result1, element.secondLargestElement(array1));
        Assertions.assertEquals(result2, element.secondLargestElement(array2));
        Assertions.assertEquals(result3, element.secondLargestElement(array3));
        Assertions.assertEquals(result4, element.secondLargestElement(array4));
    }
}