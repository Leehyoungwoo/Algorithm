package leetcode.frequency;

import java.util.*;

public class SortArrayByIncreasingFrequency {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.frequencySort(new int[]{1, 1, 2, 2, 2, 3}));
    }

    static class Solution {

        private PriorityQueue<Number> priorityQueue = new PriorityQueue<>();

        public int[] frequencySort(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else {
                    map.put(nums[i], 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                priorityQueue.offer(new Number(entry.getKey(), entry.getValue()));
            }
            int idx = 0;
            int[] res = new int[nums.length];
            while (!priorityQueue.isEmpty()) {
                Number number = priorityQueue.poll();
                for (int i = 0; i < number.frequency; i++) {
                    res[idx++] = number.value;
                }
            }

            return res;
        }
    }

    static class Number implements Comparable<Number> {
        int value;
        int frequency;

        public Number(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Number o) {
            if (this.frequency == o.frequency) {
                return o.value - this.value;
            }

            return this.frequency - o.frequency;
        }
    }
}
