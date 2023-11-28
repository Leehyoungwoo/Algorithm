package codetree.intermediateLow.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlusOneTwoFive {

    private static int n;
    private static int[] dp;
    private static final int MAX_NUM = 10_007;

    public static void main(String[] args) throws IOException {
        init();
        findAnswer();
        System.out.println(dp[n]);
    }

    private static void init() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        dp = new int[n + 1];
        dp[0] = 1;
    }

    private static void findAnswer() {
        for (int i = 1; i <= n; i++) {
            if (i - 1 >= 0) {
                dp[i] = (dp[i] + dp[i - 1]) % MAX_NUM;
            }

            if (i - 2 >= 0) {
                dp[i] = (dp[i] + dp[i - 2]) % MAX_NUM;
            }

            if (i - 5 >= 0) {
                dp[i] = (dp[i] + dp[i - 5]) % MAX_NUM;
            }
        }
    }
}
