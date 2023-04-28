package leetcode.longestCommonPrefix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrefixTest {
    @Test
    public void shouldReturnPrefix() {
        String[] array1 = {"flower", "flow", "flight"};
        String[] array2 = {"safower", "grow", "flight"};
        String[] array3 = {"power", "pow", "flight"};
        String[] array4 = {};
        String result1 = "fl";
        String result2 = "";
        String result3 = "";
        String result4 = "";
        Prefix prefix = new Prefix();
        Assertions.assertEquals(result1, prefix.longestCommonPrefix(array1));
        Assertions.assertEquals(result2, prefix.longestCommonPrefix(array2));
        Assertions.assertEquals(result3, prefix.longestCommonPrefix(array3));
        Assertions.assertEquals(result4, prefix.longestCommonPrefix(array4));
    }
}
