package leetcode.dp;

public class JumpGame {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{0, 2, 3}));
    }

    static class Solution {
        public boolean canJump(int[] nums) {
            int maxReachable = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > maxReachable) {
                    return false;
                }
                maxReachable = Math.max(maxReachable, i + nums[i]);
                if (maxReachable >= nums.length - 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
