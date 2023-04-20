package leetcode.validParentheses20;

import java.util.ArrayDeque;
import java.util.Deque;

public class Parentheses {
    public boolean isValid(String s) {
        Deque<Character> brackets = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                brackets.push(c);
            } else {
                if (brackets.isEmpty()) {
                    return false;
                }
                char up = brackets.pop();
                if (c == ')' && up != '(') {
                    return false;
                }
                if (c == ']' && up != '[') {
                    return false;
                }
                if (c == '}' && up != '{')
                    return false;
            }
        }// commit zrobić i merge do mastera
        return brackets.isEmpty();
    }
}
