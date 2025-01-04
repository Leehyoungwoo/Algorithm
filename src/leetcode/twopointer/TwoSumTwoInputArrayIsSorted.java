package leetcode.twopointer;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;

public class TwoSumTwoInputArrayIsSorted {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Arrays.stream(solution.twoSum(new int[] {2, 7, 11, 15}, 9)).forEach(System.out::println);
    }

    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum < target) {
                    left++;
                    continue;
                }

                if (sum > target) {
                    right --;
                    continue;
                }
                if (sum == target) {
                    return new int[]{left + 1, right + 1};
                }
            }
            return new int[] {-1, -1};
        }
    }
}
