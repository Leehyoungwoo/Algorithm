package leetcode.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2));
    }

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            int[] res = new int[k];
            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry<Integer, Integer>::getValue).reversed());
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                pq.offer(entry);
            }
            for (int i = 0; i < k; i++) {
                Map.Entry<Integer, Integer> entry = pq.poll();
                res[i] = entry.getKey();
            }

            return res;
        }
    }

    static class Node {
        int val;
        int count;
        public Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}
