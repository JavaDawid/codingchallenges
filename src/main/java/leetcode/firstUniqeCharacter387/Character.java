package leetcode.firstUniqeCharacter387;

public class Character {


    public int firstUniqChar(String s) {
        int[] alphabet = createAlphabet(s);
        for (int i = 0; i < s.length(); i++) {
            if (alphabet[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    private static int[] createAlphabet(String s) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        return alphabet;
    }
}
