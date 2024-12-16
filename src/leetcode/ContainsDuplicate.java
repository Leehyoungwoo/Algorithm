package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean answer = solution.containsDuplicate(new int[]{1, 2, 3, 1});
        System.out.println(answer);
    }

    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1) {
                    return true;
                }
            }

            return false;
        }
    }
}
