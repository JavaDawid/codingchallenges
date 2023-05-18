package leetcode.longestCommonPrefix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrefixTest {
    @Test
    public void shouldReturnPrefix() {
        //given
        String[] array1 = {"flower", "flow", "flight"};
        String[] array2 = {"safower", "grow", "flight"};
        String[] array3 = {"power", "pow", "flight"};
        String[] array4 = {};
        String result1 = "fl";
        String result2 = "";
        String result3 = "";
        String result4 = "";
        Prefix prefix = new Prefix();
        //when
        String s = prefix.longestCommonPrefix(array1);
        String s2 = prefix.longestCommonPrefix(array2);
        String s3 = prefix.longestCommonPrefix(array3);
        String s4 = prefix.longestCommonPrefix(array4);
        //then
        Assertions.assertEquals(result1, s);
        Assertions.assertEquals(result2, s2);
        Assertions.assertEquals(result3, s3);
        Assertions.assertEquals(result4, s4);
    }
}
