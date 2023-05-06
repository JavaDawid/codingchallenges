package leetcode.two.sum1;

import java.util.HashMap;
import java.util.Map;

public class Sum {
    public int[] twoSum(int[] nums, int target) {
        //Note: bardzo niewydajne zlozonosc O(n^2). Mozesz pomyslec jak zrobic to lepiej?
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((target == nums[i] + nums[j]) && i != j) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

}
