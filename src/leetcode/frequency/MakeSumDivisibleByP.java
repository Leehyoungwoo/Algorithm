package leetcode.frequency;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubarray(new int[]{3, 1, 4, 2}, 6));
    }

    static class Solution {
        public int minSubarray(int[] nums, int p) {
            long totalSum = 0;
            for (int num : nums) {
                totalSum = (totalSum + num) % p;
            }
            if (totalSum == 0) return 0;

            long prefixSum = 0;
            int minLen = nums.length;
            Map<Long, Integer> modIndexMap = new HashMap<>();
            modIndexMap.put(0L, -1);

            for (int i = 0; i < nums.length; i++) {
                prefixSum = (prefixSum + nums[i]) % p;
                long target = (prefixSum - totalSum + p) % p;

                if (modIndexMap.containsKey(target)) {
                    minLen = Math.min(minLen, i - modIndexMap.get(target));
                }

                modIndexMap.put(prefixSum, i);
            }

            return minLen == nums.length ? -1 : minLen;
        }
    }

}
