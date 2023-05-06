package leetcode.sortcharacter451;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class SortCharacters {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        //Note: Przy deklarowaniu zmiennej uzywaj interface Map, a nie implementacji
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

    //Note: Przkeazuj interface Map w parametrze
    private Queue<Character> sortMap(HashMap<Character, Integer> letters) {
        //Note: Wykorzystanie priority queue zadziala ale mozna to zrobic prosciej.
        // 1. posortuj klucze mapy po wartosciach (stworz liste liter posortowana po najwiekszej warotsci)
        // 2. Stworz finalny string przechodzac po posortowanej lsicie liter dodajac litery letters.get(someLetter) razy
        Queue<Character> queue = new PriorityQueue<>((a, b) -> letters.get(b) - letters.get(a));
        queue.addAll(letters.keySet());
        return queue;
    }

    private HashMap<Character, Integer> countQuantityLettersInWord(char[] s) {
        HashMap<Character, Integer> letters = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            char actualChar = s[i];
            //Note: Mozna tez toz robic
            // letters.putIfAbsent(actualChar, 0)
            // letters.put(actualChar, letters.get(actualChar))
            letters.put(actualChar, letters.getOrDefault(actualChar, 0) + 1);
        }
        return letters;
    }
}

