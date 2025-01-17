package leetcode.frequency;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(new int[] {1, 2, 0}));
    }

    static class Solution {
        public int firstMissingPositive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
            int start = 1;
            while (true) {
                if (!set.contains(start)) {
                    return start;
                } else {
                    start++;
                }
            }
        }
    }
}
