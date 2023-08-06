package leetcode.reverseString;

public class Reverse {

    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temporary = s[i];
            s[i] = s[j];
            s[j] = temporary;
            i++;
            j--;
        }

    }
}
