package leetcode.validParentheses20;

import java.util.*;

public class Parentheses {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = Map.of('(', ')', '[', ']', '{', '}');
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (brackets.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || c != brackets.get(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}