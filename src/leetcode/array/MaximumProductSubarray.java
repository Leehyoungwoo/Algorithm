package leetcode.array;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(new int[] {3, -1, 4}));
    }

    static class Solution {
        public int maxProduct(int[] nums) {
            int max = nums[0];
            int min = nums[0];
            int result = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < 0) {
                    int temp = max;
                    max = min;
                    min = temp;
                }

                max = Math.max(nums[i], max * nums[i]);
                min = Math.min(nums[i], min * nums[i]);

                result = Math.max(result, max);
            }

            return result;
        }
    }
}
