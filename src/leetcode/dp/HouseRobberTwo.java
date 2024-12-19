package leetcode.dp;

import java.util.Arrays;

public class HouseRobberTwo {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{2, 3, 2}));
    }

    static class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) return 0;
            if(nums.length == 1) return nums[0];
            return Math.max(rob(nums, 1, nums.length - 1), rob(nums, 0, nums.length - 2));
        }

        private int rob(int[] nums, int start, int end) {
            int prev = 0;
            int cur = 0;
            for (int i = start; i <= end; i++) {
                int temp = cur;
                cur = Math.max(cur, prev + nums[i]);
                prev = temp;
            }

            return cur;
        }
    }
}
