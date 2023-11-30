package codetree.intermediateLow.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SplitEqually {

    private static int n;
    private static int[] nums;
    private static boolean[][] dp;
    private static int totalSum;

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
        printAnswer();
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());

        nums = new int[n];
        totalSum = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(tokenizer.nextToken());
            totalSum += nums[i];
        }

        dp = new boolean[n + 1][totalSum / 2 + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
    }

    private static void findAnswer() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalSum / 2; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
    }

    private static void printAnswer() {
        if (totalSum % 2 == 0 && dp[n][totalSum / 2]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
