package leetcode.firstUniqeCharacter387;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CharacterTest {
    @Test
    public void shouldReturnFirstUniqChar() {
        //given
        Character character = new Character();
        String s = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";
        int output = 0;
        int output2 = 2;
        int output3 = -1;
        //when
        int i1 = character.firstUniqChar(s);
        int i2 = character.firstUniqChar(s2);
        int i3 = character.firstUniqChar(s3);
        //then
        Assertions.assertEquals(output, i1);
        Assertions.assertEquals(output2, i2);
        Assertions.assertEquals(output3, i3);
    }
}