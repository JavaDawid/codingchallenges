package leetcode.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FibonacciTest {

    @Test
    public void shouldReturnZeroWhenInputIsZero() {
        //given
        Fibonacci fibonacci = new Fibonacci();
        int input = 0;
        int expectedOutput = 0;
        //when
        int result = fibonacci.fib(input);
        //then
        Assertions.assertEquals(expectedOutput, result);
    }

    @Test
    public void shouldReturnOneWhenInputIsOne() {
        //given
        Fibonacci fibonacci = new Fibonacci();
        int input = 1;
        int expectedOutput = 1;
        //when
        int result = fibonacci.fib(input);
        //then
        Assertions.assertEquals(expectedOutput, result);
    }

    @Test
    public void shouldReturnOneWhenInputIsTwo() {
        //given
        Fibonacci fibonacci = new Fibonacci();
        int input = 2;
        int expectedOutput = 1;
        //when
        int result = fibonacci.fib(input);
        //then
        Assertions.assertEquals(expectedOutput, result);
    }

    @Test
    public void shouldReturnTwoWhenInputIsThree() {
        //given
        Fibonacci fibonacci = new Fibonacci();
        int input = 3;
        int expectedOutput = 2;
        //when
        int result = fibonacci.fib(input);
        //then
        Assertions.assertEquals(expectedOutput, result);
    }

    @Test
    public void shouldReturnThreeWhenInputIsFour() {
        //given
        Fibonacci fibonacci = new Fibonacci();
        int input = 4;
        int expectedOutput = 3;
        //when
        int result = fibonacci.fib(input);
        //then
        Assertions.assertEquals(expectedOutput, result);
    }

    @Test
    public void shouldReturnFiveWhenInputIsFive() {
        //given
        Fibonacci fibonacci = new Fibonacci();
        int input = 5;
        int expectedOutput = 5;
        //when
        int result = fibonacci.fib(input);
        //then
        Assertions.assertEquals(expectedOutput, result);
    }

}
