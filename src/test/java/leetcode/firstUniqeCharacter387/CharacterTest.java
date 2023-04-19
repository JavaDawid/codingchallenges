package leetcode.firstUniqeCharacter387;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    @Test
    public void shouldReturnFirstUniqChar() {
        //given
        Character character = new Character();

        //when
        String s = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "aabb";
        int output = 0;
        int output2 = 2;
        int output3 = -1;
        //then
        Assertions.assertEquals(output, character.firstUniqChar(s));
        Assertions.assertEquals(output2, character.firstUniqChar(s2));
        Assertions.assertEquals(output3, character.firstUniqChar(s3));
    }
}