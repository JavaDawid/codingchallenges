package leetcode.sortcharacter451;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortCharacters {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> letters = countQuantityLettersInWord(chars);
        Queue<Character> queue = sortMap(letters);
        String string = convertAtString(queue, letters);
        return string;
    }

    private String convertAtString(Queue<Character> queue, HashMap<Character, Integer> letters) {
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            Character poll = queue.poll();
            for (int i = 0; i < letters.get(poll); i++) {
                stringBuilder.append(poll);
            }
        }
        return String.valueOf(stringBuilder);
    }

    private Queue<Character> sortMap(HashMap<Character, Integer> letters) {
        Queue<Character> queue = new PriorityQueue<>((a, b) -> letters.get(b) - letters.get(a));
        queue.addAll(letters.keySet());
        return queue;
    }

    private HashMap<Character, Integer> countQuantityLettersInWord(char[] s) {
        HashMap<Character, Integer> letters = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            char actualChar = s[i];
            letters.put(actualChar, letters.getOrDefault(actualChar, 0) + 1);
        }
        return letters;
    }
}

