package leetcode.validParentheses20;

public class Parentheses {
    public boolean isValid(String s) {
        switch (s) {
            case "()":
            case "{}":
            case "[]":
                return true;
            default:
                return false;
        }
    }
}
