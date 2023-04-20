package leetcode.validParentheses20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParenthesesTest {
    @Test
    public void shouldValidParentheses() {
        Parentheses parentheses = new Parentheses();

        String a = "()";
        String b = "{}";
        String c = "[]";
        String e = "[)";
        boolean correct = true;
        boolean incorrect = false;

        Assertions.assertEquals(correct, parentheses.isValid(a));
        Assertions.assertEquals(correct, parentheses.isValid(b));
        Assertions.assertEquals(correct, parentheses.isValid(c));
        Assertions.assertEquals(incorrect, parentheses.isValid(e));
    }
}