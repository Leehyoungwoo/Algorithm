package leetcode.array;

import java.util.Arrays;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    static class Solution {
        public int search(int[] nums, int target) {
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int i = 0; i < nums.length; i++) {
//                map.put(nums[i], i);
//            }
//            return map.getOrDefault(target, -1);
            int[] copyNum = Arrays.copyOf(nums, nums.length);
            Arrays.sort(copyNum);
            int left = 0;
            int right = nums.length - 1;
            int answer = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (copyNum[mid] < target) {
                    left = mid + 1;
                }
                if (copyNum[mid] > target) {
                    right = mid - 1;
                }
                if (copyNum[mid] == target) {
                    int idx = findIdx(target, nums);
                    return idx;
                }
            }
            return answer;
        }

        private int findIdx(int target, int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (target == nums[i]) {
                    return i;
                }
            }
            return 0;
        }
    }
}
