package leetcode.sortcharacter451;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class SortCharactersTest {

    @Test
    public void shouldCountLettersAtWords() {
        String word1 = "tree";
        String word2 = "cccaaa";
        String word3 = "Aabb";

        String result1 = "eert";
        String result2 = "aaaccc";
        String result3 = "bbAa";

        SortCharacters sortCharacters = new SortCharacters();
        Assertions.assertEquals(result1, sortCharacters.frequencySort(word1));
        Assertions.assertEquals(result2, sortCharacters.frequencySort(word2));
        Assertions.assertEquals(result3, sortCharacters.frequencySort(word3));
    }
}