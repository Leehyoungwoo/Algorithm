package leetcode.Interval;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }

    static class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
            int nonOverlapping = 0;
            int lastEnd = Integer.MIN_VALUE;

            for(int[] interval : intervals) {
                if (interval[0] >= lastEnd) {
                    nonOverlapping++;
                    lastEnd = interval[1];
                }
            }

            return intervals.length - nonOverlapping;
        }
    }
}
