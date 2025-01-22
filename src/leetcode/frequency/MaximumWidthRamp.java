package leetcode.frequency;

import java.util.Stack;

public class MaximumWidthRamp {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5}));
    }

    static class Solution {
        public int maxWidthRamp(int[] nums) {
            int n = nums.length;
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++) {
                if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                    stack.push(i);
                }
            }

            int maxWidth = 0;

            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                    maxWidth = Math.max(maxWidth, i - stack.pop());
                }
            }

            return maxWidth;
        }
    }
}
