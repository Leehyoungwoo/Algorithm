package leetcode;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.twoSum(new int[] {2, 7, 11, 15}, 9);
        Arrays.stream(answer).forEach(System.out::println);
    }
}

class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] result = {};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result = new int[]{i, j};
                }
            }
        }
        return result;
    }
}
