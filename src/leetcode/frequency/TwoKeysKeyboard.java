package leetcode.frequency;

public class TwoKeysKeyboard {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSteps(11)); // 정답: 11
    }

    static class Solution {
        public int minSteps(int n) {
            if (n == 1) return 0;

            int[] dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                dp[i] = i;
            }

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j * j <= i; j++) {
                    if (i % j == 0) {
                        int factor1 = j;
                        int factor2 = i / j;

                        dp[i] = Math.min(dp[i], dp[factor1] + factor2);
                        dp[i] = Math.min(dp[i], dp[factor2] + factor1);
                    }
                }
            }

            return dp[n];
        }
    }
}
