package leetcode.frequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinDifference(new ArrayList<>(Arrays.asList("01:01","02:01","03:00"))));
    }

    static class Solution {
        public int findMinDifference(List<String> timePoints) {
            Collections.sort(timePoints);
            int minTimeGap = calculateTimeGap(timePoints.get(0), timePoints.get(timePoints.size() - 1));
            for (int i = 1; i < timePoints.size(); i++) {
                int timeGap = calculateTimeGap(timePoints.get(i - 1), timePoints.get(i));
                if (timeGap >= 0) {
                    minTimeGap = Math.min(minTimeGap, timeGap);
                }
            }

            return minTimeGap;
        }

        private int calculateTimeGap(String time1, String time2) {
            int timeGap = Integer.parseInt(time2.substring(0, 2)) - Integer.parseInt(time1.substring(0, 2));
            int minGap = Integer.parseInt(time2.substring(3)) - Integer.parseInt(time1.substring(3));
            int firstMinuteGap = timeGap * 60 + minGap;

            timeGap = Integer.parseInt(time1.substring(0, 2)) + 24 - Integer.parseInt(time2.substring(0, 2));
            minGap = Integer.parseInt(time1.substring(3)) - Integer.parseInt(time2.substring(3));
            int secondMinuteGap = timeGap * 60 + minGap;

            return Math.min(firstMinuteGap, secondMinuteGap);
        }
    }
}