package leetcode.frequency;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solution.merge(nums1, 3, nums2, 2);
        Arrays.stream(nums1).forEach(System.out::println);
    }

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int idx = 0;
            for (int i = m; i < m + n; i++) {
                nums1[i] = nums2[idx];
                idx++;
            }

            Arrays.sort(nums1);
        }
    }
}
