package leetcode.validParentheses20;

import java.util.*;

public class Parentheses {
    private static final List<Character> PARENTHESES = List.of('(', '{', '[');
    private static final Map<Character, Character> BRACKETS = Map.of('(', ')', '[', ']', '{', '}');

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (PARENTHESES.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || c != BRACKETS.get(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}