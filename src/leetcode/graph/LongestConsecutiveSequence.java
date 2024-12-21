package leetcode.graph;

import java.util.*;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
    }

    static class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            Set<Integer> set = Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.toSet());
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            int start = list.get(0);
            int max = 1;
            int count = 1;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) == ++start) {
                    count++;
                } else {
                   if(i + 1 < list.size()) {
                       start = list.get(i);
                       count = 1;
                   }
                }
                max = Math.max(max, count);
            }

            return max;
        }
    }
}
