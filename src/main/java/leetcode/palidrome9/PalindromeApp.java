package leetcode.palidrome9;

public class PalindromeApp {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        int number = palindrome.takeDigitFromUser();
        boolean isPalindrome = palindrome.isPalindrome(number);
        System.out.println("Czy cyfra " + number + " jest palindromem? \n" + isPalindrome);
    }
}
