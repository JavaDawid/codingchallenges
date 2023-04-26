package leetcode.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.asserts.Assertion;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    @Test
    public void shouldTestFibonacci() {
        Fibonacci fibonacci = new Fibonacci();
        int input1 = 2;
        int input2 = 3;
        int input3 = 4;
        int input4 = 1;
        int input5 = 0;
        int input6 = 5;

        int output1 = 1;
        int output2 = 2;
        int output3 = 3;
        int output4 = 1;
        int output5 = 0;
        int output6 = 5;

        Assertions.assertEquals(output1, fibonacci.fib(input1));
        Assertions.assertEquals(output2, fibonacci.fib(input2));
        Assertions.assertEquals(output3, fibonacci.fib(input3));
        Assertions.assertEquals(output4, fibonacci.fib(input4));
        Assertions.assertEquals(output5, fibonacci.fib(input5));
        Assertions.assertEquals(output6, fibonacci.fib(input6));
    }

}