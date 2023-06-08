package leetcode.fizzBuzz412;

import java.util.ArrayList;
import java.util.List;

public class Fizz {
    List<String> lists = new ArrayList<>();

    public List<String> fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            lists.add(getFizzBuzzValue(i));
        }
        return lists;
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
