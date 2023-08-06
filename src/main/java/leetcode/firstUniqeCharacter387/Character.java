package leetcode.firstUniqeCharacter387;

import java.util.stream.IntStream;

public class Character {


    public int firstUniqChar(String s) {
        int[] alphabet = createAlphabet(s);
        return IntStream.range(0, s.length()) //IntStream.range(0, s.length()) zamiast s.chars(), ponieważ w tym przypadku interesuje nas nie tylko wartość znaku, ale również jego indeks w ciągu znaków. Chcemy zwrócić indeks pierwszego unikalnego znaku, więc musimy śledzić zarówno znaki, jak i ich indeksy.
                .filter(value -> alphabet[s.charAt(value) - 'a'] == 1)
                .findFirst()
                .orElse(-1);
//        for (int i = 0; i < s.length(); i++) {
//            if (alphabet[s.charAt(i) - 'a'] == 1) {
//                return i;
//            }
    }

    private int[] createAlphabet(String s) {
        int[] alphabet = new int[26];
        s.chars()
                .forEach(value -> alphabet[value - 'a']++);
        //        for (int i = 0; i < s.length(); i++) {
//            alphabet[s.charAt(i) - 'a']++;
//        }
        return alphabet;
    }
}

