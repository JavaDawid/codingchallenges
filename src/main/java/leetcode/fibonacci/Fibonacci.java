package leetcode.fibonacci;

public class Fibonacci {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int digit1 = 0, digit2 = 1, current = 0;
        for (int i = 2; i <= n; i++) {
            current = digit1 + digit2;
            digit1 = digit2;
            digit2 = current;
        }
        return current;
    }
}
