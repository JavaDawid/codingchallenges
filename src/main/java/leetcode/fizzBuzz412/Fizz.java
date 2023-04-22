package leetcode.fizzBuzz412;
import java.util.ArrayList;
import java.util.List;

public class Fizz {
    public List<String> fizzBuzz(int n) {
        List<String> lists = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                lists.add("FizzBuzz");
            } else if ((i % 3 == 0) || (i % 5 == 0)) {
                if (i % 3 == 0) {
                    lists.add("Fizz");
                } else if (i % 5 == 0) {
                    lists.add("Buzz");
                }
            } else {
                lists.add(String.valueOf(i));
            }
        }
        return lists;
    }
}
