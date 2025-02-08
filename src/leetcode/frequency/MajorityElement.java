package leetcode.frequency;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[]{3, 2, 3}) == 3);
        System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}) == 2);
    }

    static class Solution {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
                if (entry.getValue() > nums.length / 2) {
                    return entry.getKey();
                }
            }

            return -1;
        }
    }
}
