package leetcode.reverseString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseTest {
    @Test
    void shouldReverseString() {
        Reverse reverse = new Reverse();
        char[] input = {'h', 'e', 'l', 'l', 'o'};
        char[] expected = {'o', 'l', 'l', 'e', 'h'};
        reverse.reverseString(input);
        assertArrayEquals(expected, input);

        char[] input2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        char[] expected2 = {'h', 'a', 'n', 'n', 'a', 'H'};
        reverse.reverseString(input2);
        assertArrayEquals(expected2, input2);
    }
}
