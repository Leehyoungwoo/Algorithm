package leetcode.frequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[] {1,3}, new int[]{2}));
    }

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            List<Integer> merged = new ArrayList<>();
            for (int i = 0; i < nums1.length; i++) {
                merged.add(nums1[i]);
            }
            for (int i = 0; i < nums2.length; i++) {
                merged.add(nums2[i]);
            }
            Collections.sort(merged);
            if (merged.size() % 2 == 1) {
                return (double) merged.get(merged.size() / 2);
            }
            return (double) (merged.get(merged.size() / 2) + merged.get(merged.size() / 2 - 1)) / 2;
        }
    }
}
