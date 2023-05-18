package leetcode.two.sum1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SumTest {
    @Test
    public void shouldGivePositiveTarget() {
        //given
        Sum sum = new Sum();
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = {0, 1};
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = {1, 2};
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = {0, 1};
        //when
        int[] ints1 = sum.twoSum(nums1, target1);
        int[] ints2 = sum.twoSum(nums2, target2);
        int[] ints3 = sum.twoSum(nums3, target3);

        //then
        Assertions.assertArrayEquals(result1, ints1);
        Assertions.assertArrayEquals(result2, ints2);
        Assertions.assertArrayEquals(result3, ints3);
    }
}