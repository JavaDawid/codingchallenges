package leetcode.validParentheses20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParenthesesTest {
    @Test
    public void shouldValidParentheses() {
        //given
        Parentheses parentheses = new Parentheses();

        String a = "()";
        String b = "{}";
        String c = "[]";
        String d = "[](){}";
        String e = "[)";
        //when
        boolean valid1 = parentheses.isValid(a);
        boolean valid2 = parentheses.isValid(b);
        boolean valid3 = parentheses.isValid(c);
        boolean valid4 = parentheses.isValid(e);
        boolean valid5 = parentheses.isValid(d);

        //then
        Assertions.assertTrue(valid1);
        Assertions.assertTrue(valid2);
        Assertions.assertTrue(valid3);
        Assertions.assertTrue(valid5);
        Assertions.assertFalse(valid4);
    }
}