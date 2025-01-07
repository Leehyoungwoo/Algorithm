package leetcode.frequency;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(new int[] {3,2,1,5,6,4} , 2));
    }

    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            Collections.sort(list, Collections.reverseOrder());
            return list.get(k - 1);
        }
    }
}
