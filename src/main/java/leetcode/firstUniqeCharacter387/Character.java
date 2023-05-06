package leetcode.firstUniqeCharacter387;

public class Character {


    public int firstUniqChar(String s) {
        int[] alphabet = new int[26];

        //Note: dawaj nawiasy w for {}, nawet jezeli wykonywana jest tylko jedna komenda w petli, jest to strasznie bledogenne
        //Note: wyciagnalbym tworzenie "mapy" literaToListaWystpaien d funkcji
        for (int i = 0; i < s.length(); i++)
            alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (alphabet[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }


}
