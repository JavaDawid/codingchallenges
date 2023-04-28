package leetcode.longestCommonPrefix;

import java.util.Arrays;

public class Prefix {
    public String longestCommonPrefix(String[] str) {
        if (str == null || str.length == 0) {
            return "";
        }
        String word = str[0];
        for (int i = 1; i < str.length; i++) {
            while (str[i].indexOf(word) != 0) {//indexOf szuka indexu od którego podany ciąg znaków(word) zaczyna się w badanym słowie
                word = word.substring(0, word.length() - 1);
                if (word.isEmpty()) {
                    return "";
                }
            }
        }
        return word;
    }
}
