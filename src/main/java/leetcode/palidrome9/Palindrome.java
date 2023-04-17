package leetcode.palidrome9;

import java.util.Scanner;

public class Palindrome {
    public int takeDigitFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę do sprawdzenia czy jest polindromem");
        return scanner.nextInt();
    }

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int original = x;
        int reversed = 0;
        while (x > 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        return original == reversed;
    }
}
