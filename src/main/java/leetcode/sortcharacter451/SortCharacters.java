package leetcode.sortcharacter451;

import java.util.*;
import java.util.stream.Collectors;

public class SortCharacters {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> letters = countQuantityLettersInWord(chars);
        Map<Character, Integer> sortedMap = sortMap(letters);
        return convertAtString(sortedMap);
    }

    private String convertAtString(Map<Character, Integer> sortedMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            for (int i = 0; i < value; i++) {
                stringBuilder.append(key);
            }
        }
        return String.valueOf(stringBuilder);
    }

    private Map<Character, Integer> sortMap(Map<Character, Integer> letters) {

        return letters.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private HashMap<Character, Integer> countQuantityLettersInWord(char[] s) {
        HashMap<Character, Integer> letters = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            char actualChar = s[i];
            letters.putIfAbsent(actualChar, 0);
            letters.put(actualChar, letters.get(actualChar) + 1);
        }
        return letters;
    }
}

