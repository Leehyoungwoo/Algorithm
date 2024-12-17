package leetcode.array;

public class MaximumSubarray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(answer);
    }

    static class Solution {
        public int maxSubArray(int[] nums) {
            int maxSum = nums[0];
            int curSum = 0;

            for (int i = 0; i < nums.length; i++) {
                curSum += nums[i];
                maxSum = Math.max(curSum, maxSum);

                if (curSum < 0) {
                    curSum = 0;
                }
            }

            return maxSum;
        }
    }
}
