package leetcode.frequency;

public class FindPeakElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findPeakElement(new int[]{1, 2, 3, 1}));
    }

    static class Solution {
        public int findPeakElement(int[] nums) {
            if (nums.length == 1) {
                return 0;
            }
            int idx = -1;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    idx = i;
                }
            }
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    return i;
                }
            }
            return idx;
        }
    }
}
