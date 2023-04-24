package leetcode.increase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IncreaseTest {
    @Test
    public void shouldIncrease() {
        int numberA = 10;
        int numberB = 7;
        int zero = 0;
        int result = 70;
        Increase increase = new Increase();
        Assertions.assertEquals(result,increase.increase(numberA,numberB,zero));
    }

}