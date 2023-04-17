package leetcode.palidrome9;

import java.util.Scanner;

public class Palindrome {
    public int takeDigitFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę do sprawdzenia czy jest polindromem");
        return scanner.nextInt();
    }

    public boolean isPalindrome(int original) {
        if (original < 0)
            return false;

        int reversed = 0;
        while (original > 0) {
            int digit = original % 10;
            reversed = reversed * 10 + digit;
            original /= 10;
        }
        return original == reversed;
    }
}
