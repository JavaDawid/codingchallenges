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
        boolean correct = true;
        boolean incorrect = false;
        //when
        boolean valid1 = parentheses.isValid(a);
        boolean valid2 = parentheses.isValid(b);
        boolean valid3 = parentheses.isValid(c);
        boolean valid4 = parentheses.isValid(e);
        boolean valid5 = parentheses.isValid(d);

        //then
        Assertions.assertEquals(correct, valid1);
        Assertions.assertEquals(correct, valid2);
        Assertions.assertEquals(correct, valid3);
        Assertions.assertEquals(incorrect, valid4);
        Assertions.assertEquals(correct, valid5);
    }
}