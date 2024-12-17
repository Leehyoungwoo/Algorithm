package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MissingNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(new int[] {3, 0, 1}));
    }

    static class Solution {
        public int missingNumber(int[] nums) {
//            List<Integer> list = Arrays.stream(nums)
//                    .boxed()
//                    .collect(Collectors.toList());
//            for (int i = 0; i <= nums.length; i++) {
//                if (!list.contains(i)) {
//                    return i;
//                }
//            }
//            return -1;
            int n = nums.length;
            int totalSum = n * (n + 1) / 2;
            return totalSum - Arrays.stream(nums).sum();
        }
    }
}
