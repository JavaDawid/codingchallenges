package leetcode.two.sum1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SumTest {
    @Test
    public void shouldGivePositiveTarget() {
        //given
        Sum sum = new Sum();
        //when
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = {0, 1};
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = {1,2};
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = {0, 1};
        //then
        Assertions.assertArrayEquals(result1, sum.twoSum(nums1, target1));
        Assertions.assertArrayEquals(result2, sum.twoSum(nums2, target2));
        Assertions.assertArrayEquals(result3, sum.twoSum(nums3, target3));
    }
}