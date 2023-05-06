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
        String d = "[](){}";
        String e = "[)";
        //Note: Zrobilbym inline na correct, incorret. Te zmienne nic nie wnosza.
        boolean correct = true;
        boolean incorrect = false;

        Assertions.assertEquals(correct, parentheses.isValid(a));
        Assertions.assertEquals(correct, parentheses.isValid(b));
        Assertions.assertEquals(correct, parentheses.isValid(c));
        Assertions.assertEquals(incorrect, parentheses.isValid(e));
        Assertions.assertEquals(correct, parentheses.isValid(d));
    }
}