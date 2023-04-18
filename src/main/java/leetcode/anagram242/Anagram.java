package leetcode.anagram242;

public class Anagram {

    public boolean isAnagram(String correctWord, String rearrangingWord) {
        if (correctWord.length() != rearrangingWord.length()) {
            return false;
        }
        int[] array = new int[26];
        for (int i = 0; i < correctWord.length(); i++) {
            array[correctWord.charAt(i) - 'a']++;
            array[rearrangingWord.charAt(i) - 'a']--;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
