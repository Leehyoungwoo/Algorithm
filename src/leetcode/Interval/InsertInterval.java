package leetcode.Interval;

import java.util.*;
import java.util.stream.Collectors;

public class InsertInterval {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInteval = {2, 5};
        System.out.println(solution.insert(intervals, newInteval));
    }

    static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<List<Integer>> res = new ArrayList<>();
            List<List<Integer>> intevalList = Arrays.stream(intervals)
                    .map(array -> Arrays.stream(array).boxed().collect(Collectors.toList()))
                    .collect(Collectors.toList());
            intevalList.add(new ArrayList<>(Arrays.asList(newInterval[0], newInterval[1])));
            Collections.sort(intevalList, Comparator.comparing(a -> a.get(0)));
            int start = intevalList.get(0).get(0);
            int end = intevalList.get(0).get(1);
            for (List<Integer> interval : intevalList) {
                if (end < interval.get(0)) {
                    res.add(new ArrayList<>(Arrays.asList(start, end)));
                    start = interval.get(0);
                    end = interval.get(1);
                    continue;
                }

                if (start <= interval.get(1) && end >= interval.get(1)) {
                    continue;
                }

                if (start <= interval.get(0) && end <= interval.get(1)) {
                    end = interval.get(1);
                }
            }
            // 마지막 원소 넣어줘야함
            res.add(new ArrayList<>(Arrays.asList(start, end)));

            return res.stream().map(
                    list -> list.stream()
                            .mapToInt(Integer::intValue)
                            .toArray())
                    .toArray(int[][]::new);
        }
    }
}
