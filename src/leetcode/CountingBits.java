package leetcode;

import java.util.Arrays;

public class CountingBits {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Arrays.stream(solution.countBits(5)).forEach(System.out::println);
    }

    static class Solution {
        public int[] countBits(int num) {
            int[] answer = new int[num + 1];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = Integer.bitCount(i);
            }
            return answer;
        }
    }
}
