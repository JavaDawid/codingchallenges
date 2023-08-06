package leetcode.fizzBuzz412;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Fizz {

    public List<String> fizzBuzz(int n) {
        return IntStream.range(1, n + 1)
                .mapToObj(value -> getFizzBuzzValue(value))
                .collect(Collectors.toList());
    }

    private String getFizzBuzzValue(int i) {
        if ((i % 3 == 0) && (i % 5 == 0)) {
            return "FizzBuzz";
        } else if ((i % 3 == 0) || (i % 5 == 0)) {
            if (i % 3 == 0) {
                return "Fizz";
            } else if (i % 5 == 0) {
                return "Buzz";
            }
        }
        return String.valueOf(i);
    }
}