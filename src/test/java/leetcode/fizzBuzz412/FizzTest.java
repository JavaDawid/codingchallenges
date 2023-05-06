package leetcode.fizzBuzz412;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FizzTest {
    List<String> result = new ArrayList<>();

    @AfterEach
    public void shouldCleanList() {
        result.clear();
    }

    @Test
    public void shouldReturnFizz() {
        Fizz fizz = new Fizz();
        int a = 3;
        result.add("1");
        result.add("2");
        result.add("Fizz");
        Assertions.assertEquals(result, fizz.fizzBuzz(a));
    }

    @Test
    public void shouldReturnFizzAndBuzz() {
        Fizz fizz = new Fizz();
        int a = 5;
        result.add("1");
        result.add("2");
        result.add("Fizz");
        result.add("4");
        result.add("Buzz");
        Assertions.assertEquals(result, fizz.fizzBuzz(a));
    }

    @Test
    public void shouldReturnFizzBuzz() {
        Fizz fizz = new Fizz();
        int a = 15;
        //Note:
        // 1. Zostawilbym tylko ten test, ustawil a = 16.
        // 2. Zamiast result.add. zrobilbym result.addAll(List.of(1, 2, Fizz))
        // lub wreczy wygenerowal liste liczb 1-16 i popodmienial elementy liscie na Fizz, Buzz i Fizzbuzz
        result.add("1");
        result.add("2");
        result.add("Fizz");
        result.add("4");
        result.add("Buzz");
        result.add("Fizz");
        result.add("7");
        result.add("8");
        result.add("Fizz");
        result.add("Buzz");
        result.add("11");
        result.add("Fizz");
        result.add("13");
        result.add("14");
        result.add("FizzBuzz");
        //Note: fizz.fizzBuzz(a) - zrob to w sekcki 'when'
        Assertions.assertEquals(result, fizz.fizzBuzz(a));
    }

}