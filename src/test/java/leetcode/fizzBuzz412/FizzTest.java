package leetcode.fizzBuzz412;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class  FizzTest {
    @Test
    public void shouldReturnFizzBuzz() {
        //given
        Fizz fizz = new Fizz();
        int a = 16;
        List<String> expectedOutput = List.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz",
                "13", "14", "FizzBuzz", "16");
        //when
        List<String> strings = fizz.fizzBuzz(a);

        //then
        Assertions.assertEquals(expectedOutput, strings);
    }

}