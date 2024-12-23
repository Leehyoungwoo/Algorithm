package leetcode.Interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomTwo {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minMeetingRooms(new int[][] {{6, 15}, {13, 20}, {6,7}}));
    }

    static class Solution {
        public int minMeetingRooms(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return 0;
            }
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            minHeap.add(intervals[0][1]);

            for (int i = 1; i < intervals.length; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];

                if (start >= minHeap.peek()) {
                    minHeap.poll();
                }
                minHeap.add(end);
            }

            return minHeap.size();
        }
    }
}
