package leetcode.frequency;

public class MinimumNumberOfIncrementOnSubarraysToFormATargetArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minNumberOperations(new int[] {1,2,3,2,1}));
    }

    static class Solution {
        public int minNumberOperations(int[] target) {
            int operations = target[0];
            for (int i = 1; i < target.length; i++) {
                int diff = target[i] - target[i - 1];
                if (diff > 0) {
                    operations += diff;
                }
            }
            return operations;
        }
    }
}
