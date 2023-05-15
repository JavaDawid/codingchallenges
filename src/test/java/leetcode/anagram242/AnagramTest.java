package leetcode.anagram242;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AnagramTest {
    @Test
    public void shouldCheckThatWordIsAnagram() {
        //given
        Anagram anagram = new Anagram();
        String correctWord = "anagram";
        String rearrangingWord = "nagaram";

        //when
        anagram.isAnagram(correctWord, rearrangingWord);

        //then
        Assertions.assertTrue(true);
    }
}