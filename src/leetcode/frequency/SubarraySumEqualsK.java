package leetcode.frequency;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.subarraySum(new int[]{1, 2, 3}, 3);
    }

    static class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            int prefix = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (Integer num : nums) {
                prefix += num;
                if (map.containsKey(prefix - k)) {
                    count += map.get(prefix - k);
                }

                map.put(prefix, map.getOrDefault(prefix, 0) + 1);
            }

            return count;
        }
    }
}
