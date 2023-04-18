package leetcode.palidrome9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {
    @Test
    void shouldIsPalindrome() {
        //given
        Palindrome palindrome = new Palindrome();
        int a = 121;
        int b = -121;
        int c = 10;
        //when

        //then
        assertEquals(true, palindrome.isPalindrome(a));
        assertEquals(false, palindrome.isPalindrome(b));
        assertEquals(false, palindrome.isPalindrome(c));
    }
}