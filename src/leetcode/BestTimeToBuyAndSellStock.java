package leetcode;

public class BestTimeToBuyAndSellStock {
    static class Solution {
        public static int maxProfit(int[] prices) {
            int[] dp = new int[prices.length];
            dp[0] = prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i] = Math.min(prices[i], dp[i - 1]);
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < prices.length; i++) {
                dp[i] = prices[i] - dp[i];
                max = Math.max(max, dp[i]);
            }
            if (max <= 0) {
                return 0;
            }

            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(answer);
    }
}
