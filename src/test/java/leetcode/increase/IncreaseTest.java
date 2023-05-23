package leetcode.increase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IncreaseTest {
    @Test
    public void shouldIncrease() {
        //given
        int numberA = 10;
        int numberB = 7;
        int result = 70;
        Increase increase = new Increase();
        //when
        int increase1 = increase.increase(numberA, numberB);

        //then
        Assertions.assertEquals(result, increase1);
    }

    @Test
    public void negativeDigit() {
        //given
        int numberA = -10;
        int numberB = 7;
        int result = -70;
        Increase increase = new Increase();

        //when
        int increase1 = increase.increase(numberA, numberB);

        //then
        Assertions.assertEquals(result, increase1);
    }
    @Test
    public void doubleNegativeDigit() {
        //given
        int numberA = -10;
        int numberB = -7;
        int result = 70;
        Increase increase = new Increase();

        //when
        int increase1 = increase.increase(numberA, numberB);

        //then
        Assertions.assertEquals(result, increase1);
    }

}