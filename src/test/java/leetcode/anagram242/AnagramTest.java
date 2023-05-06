package leetcode.anagram242;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AnagramTest {
    @Test
    public void shouldCheckThatWordIsAnagram() {

        //given
        Anagram anagram = new Anagram();
        //when
        boolean anagram1 = anagram.isAnagram("anagram", "nagaram");
        boolean anagram2 = anagram.isAnagram("rat", "car");
        //then
        //Note: Use: Assertions.assertTrue
        Assertions.assertEquals(true, anagram1);
        Assertions.assertEquals(false, anagram2);
    }
}