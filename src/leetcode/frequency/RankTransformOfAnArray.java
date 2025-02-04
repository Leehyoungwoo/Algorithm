package leetcode.frequency;

import java.util.*;
import java.util.stream.Collectors;

public class RankTransformOfAnArray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.arrayRankTransform(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12});
        System.out.println();
    }

    static class Solution {
        public int[] arrayRankTransform(int[] arr) {
            Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            Map<Integer, Integer> rank = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                if (!rank.containsKey(list.get(i))) {
                    rank.put(list.get(i), i + 1);
                }
            }

            int[] result = new int[arr.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = rank.get(arr[i]);
            }

            return result;
        }
    }
}
