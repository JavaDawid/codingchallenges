package leetcode.longestCommonPrefix;

import java.util.Arrays;

public class Prefix {
    public String longestCommonPrefix(String[] str) {
        if (str == null || str.length == 0) {
            return "";
        }
        return Arrays.stream(str)
                .reduce((prefix, word) -> {
                    while (word.indexOf(prefix) != 0) {
                        prefix = prefix.substring(0, prefix.length() - 1);
                    }
                    return prefix;
                })
                .orElse("");
    }
}