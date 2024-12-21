package leetcode.Interval;

import java.util.*;
import java.util.stream.Collectors;

public class MeetingRoom {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canAttendMeetings(new int[][] {
                {13, 15},
                {1, 13}
        }));
    }

    static class Solution {
        public boolean canAttendMeetings(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return true;
            }
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            int start = intervals[0][0];
            int end = intervals[0][1];
            for (int[] interval : intervals) {
                if (start <= interval[0] && end >= interval[1]) {
                    continue;
                }

                // 범위 밖으로 나가는 경우 !!! 같으면 포함되는지 아닌지 주의해야함
                if (end <= interval[0]) {
                    res.add(new ArrayList<>(Arrays.asList(start, end)));
                    start = interval[0];
                    end = interval[1];
                    continue;
                }

                // 시작은 범위 안이지만 끝 범위가 범위 밖으로 나가는 경우
                if (start <= interval[0] && end < interval[1]) {
                    end = interval[1];
                }
            }
            res.add(new ArrayList<>(Arrays.asList(start, end)));

            return res.size() == intervals.length;
        }
    }
}
