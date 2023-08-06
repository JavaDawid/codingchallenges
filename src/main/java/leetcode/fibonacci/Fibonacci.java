package leetcode.fibonacci;

import java.util.stream.Stream;

public class Fibonacci {
    public int fib(int n) {
        return Stream.iterate(new int[]{0, 1}, ints -> new int[]{ints[1], ints[0] + ints[1]})
                .limit(n + 1)
                .map(ints -> ints[0])//zwraca pierwszy element dwuelementowej tablicy
                .reduce((integer, integer2) -> integer2)//zwraca drugi element dwuelementowej tablicy
                .orElse(0);
    }
}
