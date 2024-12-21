package leetcode.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.merge(new int[][]{
                {0, 0},
                {1, 2},
                {5, 5},
                {2, 4},
                {3, 3},
                {5, 6},
                {5, 6},
                {4, 6},
                {0, 0},
                {1, 2},
                {0, 2},
                {4, 5}
        }));
    }

    static class Solution {

        private final int max = 10_000;

        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            List<List<Integer>> res = new ArrayList<>();
            int start = intervals[0][0];
            int end = intervals[0][1];;
            for (int[] interval : intervals) {

                if (end < interval[0]) {
                    res.add(new ArrayList<>(Arrays.asList(start, end)));
                    start = interval[0];
                    end = interval[1];
                    continue;
                }

                if (start <= interval[0] && end >= interval[1]) {
                    continue;
                }

                if (start <= interval[0] && end <= interval[1]) {
                    end = interval[1];
                }
            }
            res.add(new ArrayList<>(Arrays.asList(start, end)));

            return res.stream().map(list ->
                    list.stream()
                            .mapToInt(Integer::intValue)
                            .toArray())
                    .toArray(int[][]::new);
        }
    }
}
