package leetcode;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{3, 4, 5, 1, 2}));
    }

    static class Solution {
        public int findMin(int[] nums) {
            Arrays.sort(nums);
            return nums[0];
        }
    }
}
