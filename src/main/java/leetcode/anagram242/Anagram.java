package leetcode.anagram242;
import java.util.Map;
import java.util.stream.Collectors;


public class Anagram {

    public boolean isAnagram(String correctWord, String rearrangingWord) {
        if (correctWord.length() != rearrangingWord.length()) {
            return false;
        }
        Map<Character, Long> correctWordLetters = frequencyMap(correctWord);
        Map<Character, Long> rearrangingWordLetters = frequencyMap(rearrangingWord);

        return correctWordLetters.equals(rearrangingWordLetters);
    }

    private static Map<Character, Long> frequencyMap(String correctWord) {
        return correctWord.chars().mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(character -> character, Collectors.counting()));
    }
}

//    int[] array = new int[26];
//        for (int i = 0; i < correctWord.length(); i++) {
//        array[correctWord.charAt(i) - 'a']++;
//        array[rearrangingWord.charAt(i) - 'a']--;
//        }
//        for (int i = 0; i < array.length; i++) {
//        if (array[i] != 0) {
//        return false;
//        }
//        }
//        return true;
//
//               1
//    Map<Character, Integer> correctWordMap = new HashMap<>();
//        correctWord.chars().mapToObj(value -> (char) value)
//                .forEach(character -> correctWordMap.put(character, correctWordMap.getOrDefault(character, 0) + 1));
//
//                Map<Character, Integer> rearrangingWordMap = new HashMap<>();
//        rearrangingWord.chars().mapToObj(value -> (char) value)
//        .forEach(character -> rearrangingWordMap.put(character, rearrangingWordMap.getOrDefault(character, 0) + 1));
//
//        return correctWordMap.equals(rearrangingWordMap);
//
//                 2
//public boolean isAnagram(String correctWord, String rearrangingWord) {
//    if (correctWord.length() != rearrangingWord.length()) {
//        return false;
//    }
//    Map<Character, Long> correctWordLetters = frequencyMap(correctWord);
//    Map<Character, Long> rearrangingWordLetters = frequencyMap(rearrangingWord);
//
//    return correctWordLetters.equals(rearrangingWordLetters);
//}
//
//    private static Map<Character, Long> frequencyMap(String correctWord) {
//        return correctWord.chars().mapToObj(value -> (char) value)
//                .collect(Collectors.groupingBy(character -> character, Collectors.counting()));
//    }
//}