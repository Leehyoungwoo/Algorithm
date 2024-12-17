package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.twoSum(new int[] {2, 7, 11, 15}, 9);
        Arrays.stream(answer).forEach(System.out::println);
    }
}

class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            // cur + x = target
            // x = target - cur
            int x = target - cur;
            if (map.containsKey(x)) {
                return new int[] {map.get(x), i};
            }
            map.put(cur, i);
        }

        return null;
    }
}
